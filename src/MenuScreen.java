public interface MenuScreen {
    void render(Account account);
    MenuScreen handleInput(String input, Account account);
}
