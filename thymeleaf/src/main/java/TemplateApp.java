import java.time.LocalDate;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

/**
 * Hello Thymeleaf
 */
public class TemplateApp
{
    private TemplateEngine templateEngine;

    public static void main( String[] args )
    {
        final TemplateApp app = new TemplateApp();
        app.start();
    }

    private void start(){
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver( configureTemplateResolver() );

        final TemplateSpec templateSpec = createTemplateSpec();

        System.out.println( templateEngine.process(
                templateSpec,
                initVariableData( new ToyRobot( "Fred", LocalDate.of( 2022, 2, 2 ), 38 ))));
        System.out.println( templateEngine.process(
                templateSpec,
                initVariableData( new ToyRobot( "Pluto", LocalDate.of( 1873, 4, 1 ), 13 ))));
        System.out.println( templateEngine.process(
                templateSpec,
                initVariableData( new ToyRobot( "Ming", LocalDate.now(), 21 ))));
    }


    //FIXME
    private ITemplateResolver configureTemplateResolver(){
        final FileTemplateResolver resolver = new FileTemplateResolver();
        return resolver;
    }

    private TemplateSpec createTemplateSpec(){
        //FIXME
        return new TemplateSpec("src/main/resources/index.html",TemplateMode.HTML);
    }

    private Context initVariableData( ToyRobot aRobot ){
        final Context ctx = new Context();
        ctx.setVariable( "bot", aRobot );
        return ctx;
    }
}
