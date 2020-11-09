package restassuredTests;

public final class EndPoint {
    public final static String ALLCARDS = "/cards";
    public final static String CARD= "/cards/{name}";
    public final static String CARDSBYQUALITY = "cards/qualities/{qualities}/";
    public final static String POSTLIKERS= "/p/{post}";

    private EndPoint() {
        throw new IllegalStateException();
    }
}
