package br.com.estudos.jpasparkfreemarker.controller;

import static spark.Spark.setPort;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import br.com.estudos.jpasparkfreemarker.dao.impl.ContaDAO;
import br.com.estudos.jpasparkfreemarker.dao.impl.MovimentacaoDAO;
import br.com.estudos.jpasparkfreemarker.entity.Conta;
import br.com.estudos.jpasparkfreemarker.facade.CrudFacade;
import br.com.estudos.jpasparkfreemarker.utils.JPAUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author turbiani
 *
 */
public class MainController {
	private final Configuration 	cfg;
	private final ContaDAO      	contaDAO;
	private final MovimentacaoDAO	movimentacaoDAO;
	private final JPAUtil    		JPAUtil;
	
	public MainController() throws IOException{
		this.cfg 	  			= createFreemarkerConfiguration();
		this.contaDAO 			= new ContaDAO();
		this.movimentacaoDAO 	= new MovimentacaoDAO();
		this.JPAUtil            = new JPAUtil();
		
		setPort(8082);
        carregaRotas();
	}
	
	public static void main(String[] args) {
		try {
			new MainController();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void carregaRotas() throws IOException{
		//HOME
		Spark.get(new TemplateBaseRoute("/", "index.ftl") {
			@Override
			protected void doHandle(Request request, Response response, Writer writer)
					throws IOException, TemplateException {
				CrudFacade<Conta> crudConta = new CrudFacade<Conta>(Conta.class);
				
				Conta conta;
				try {
					conta = crudConta.busca(2);
				
				Map<String, Object> document = new HashMap<String, Object>();

                if (conta.getTitular() != null) {
                    document.put("name", conta.getTitular());
                }
                
                template.process(document, writer);
                
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});		
		//CONTA CRUD
		Spark.get(new TemplateBaseRoute("/conta", "/conta/index.ftl") {
			@Override
			protected void doHandle(Request request, Response response, Writer writer)
					throws IOException, TemplateException {
				Map<String, Object> document = new HashMap<String, Object>();
                template.process(document, writer);
			}
		});
		/*Spark.get(new TemplateBaseRoute("/conta/:id", "/conta/dadosConta.ftl") {
			@Override
			protected void doHandle(Request request, Response response, Writer writer)
					throws IOException, TemplateException {
				 
				String id = request.params(":id");
				CrudFacade<Conta> crudConta = new CrudFacade<Conta>(Conta.class);
				
				try {
					Conta conta = crudConta.busca(Integer.parseInt(id));
				 
					Map<String, Object> document = new HashMap<String, Object>();
					
					if(conta!=null){
						document.put("conta", conta);
					}
					
					template.process(document, writer);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});*/
		Spark.delete(new TemplateBaseRoute("/conta/:id", "/conta/contaRemovida.ftl") {
			@Override
			protected void doHandle(Request request, Response response, Writer writer)
					throws IOException, TemplateException {
				 
				String id = request.params(":id");
				CrudFacade<Conta> crudConta = new CrudFacade<Conta>(Conta.class);
				
				try {
					crudConta.remove(Integer.parseInt(id));
				 
					Map<String, Object> document = new HashMap<String, Object>();
										
					template.process(document, writer);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Spark.get(new TemplateBaseRoute("/conta/lista", "/conta/listaContas.ftl") {
			@Override
			protected void doHandle(Request request, Response response, Writer writer)
					throws IOException, TemplateException {
				 
				CrudFacade<Conta> crudConta = new CrudFacade<Conta>(Conta.class);
				
				try {
					List<Conta> contas = crudConta.lista();
				 
					Map<String, Object> document = new HashMap<String, Object>();
					
					if(contas!=null){
						document.put("contas", contas);
					}
										
					template.process(document, writer);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
	
	
	
	abstract class TemplateBaseRoute extends Route{
		final Template template;
		/**
		 * @param path
		 * @param templateName
		 * @throws IOException 
		 */
		protected TemplateBaseRoute(final String path, final String templateName) throws IOException {
			super(path);
            template = cfg.getTemplate(templateName);			
		}
		
		@Override
        public Object handle(Request request, Response response) {
            StringWriter writer = new StringWriter();
            try {
                doHandle(request, response, writer);
            } catch (Exception e) {
                e.printStackTrace();
                response.redirect("/internal_error");
            }
            return writer;
        }

        protected abstract void doHandle(final Request request, final Response response, final Writer writer)
        throws IOException, TemplateException;
		
	}
	
	private Configuration createFreemarkerConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(MainController.class, "/freemarker");
        return configuration;
    }
}
