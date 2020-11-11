package restassuredTests.pojo;

public class Cards {

        private int cost;

        private String cardSet;

        private String cardId;

        private String name;

    public Cards() {
    }

    public int getCost ()
        {
            return cost;
        }

        public void setCost (int cost)
        {
            this.cost = cost;
        }

        public String getCardSet ()
        {
            return cardSet;
        }

        public void setCardSet (String cardSet)
        {
            this.cardSet = cardSet;
        }

        public String getCardId ()
        {
            return cardId;
        }

        public void setCardId (String cardId)
        {
            this.cardId = cardId;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [cost = "+cost+", cardSet = "+cardSet+", cardId = "+cardId+", name = "+name+"]";
        }
}


