import java.util.ArrayList;
import java.util.List;

public class DataBundleScreen implements MenuScreen{
    DataBundle dataBundle;
    List<DataBundle> bundles = new ArrayList<>(){{
       add(new DataBundle(2.45, 20, 30));
        add(new DataBundle(6.13, 50, 30));
        add(new DataBundle(12.81, 100, 30));
        add(new DataBundle(39.00, 200, 30));
        add(new DataBundle(111.43, 300, 30));
        add(new DataBundle(263.38, 400, 30));
    }};
    @Override
    public void render(Account account) {
        System.out.println("Enter your choice: ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        int bundleChoice = Integer.parseInt(input);
        DataBundle myBundle = bundles.get(bundleChoice);
        dataBundle.describe(myBundle);
        return new MainMenuScreen();
    }
}
