package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/java/features",glue ="StepDefinitions"
,monochrome=true,tags = "@home",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json"
})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }

	
}
