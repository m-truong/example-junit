import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.ParameterResolutionException;

// *** TODO: This was a Class that was created inside /Test folder; but not a test class ; it has no runnable <>
//  test arrows
// This is in-charge of the dependency Injection; and checking if @Inject dependency correct Java Class Type!

public class BankAccountParameterResolver implements ParameterResolver {

    // *** TODO: This is in-charge of checking the type of the injected dependency to see if it's the correct type!
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == BankAccount.class;
    }

    // *** TODO: This is in-charge of giving the dependency; Creates the Dependency
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new BankAccount(0, 0); // Always Instantiates just a BankAccount(0,0)
    }
}
