package javaapp10;

public class HockeyTeam implements Comparable {

    private int goldPrice;
    private String name;
    private int serPrice;
    private int bronzePrice;

    public HockeyTeam(String name, int goldPrice, int serPrice, int bronzePrice) {
        this.name = name;
        this.goldPrice = goldPrice;
        this.serPrice = serPrice;
        this.bronzePrice = bronzePrice;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HockeyTeam that = (HockeyTeam) o;

        if (goldPrice != that.goldPrice) return false;
        if (serPrice != that.serPrice) return false;
        if (bronzePrice != that.bronzePrice) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = goldPrice;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + serPrice;
        result = 31 * result + bronzePrice;
        return result;
    }

    public String toString() {
        return "Команда " + name + " \t" + goldPrice + " \t" + serPrice + " \t" + bronzePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(int goldPrice) {
        this.goldPrice = goldPrice;
    }

    public int getSerPrice() {
        return serPrice;
    }

    public void setSerPrice(int serPrice) {
        this.serPrice = serPrice;
    }

    public int getBronzePrice() {
        return bronzePrice;
    }

    public void setBronzePrice(int bronzePrice) {
        this.bronzePrice = bronzePrice;
    }

    public int compareTo(Object o) {
        if (!(o instanceof HockeyTeam)) return 1;
        HockeyTeam h = (HockeyTeam) o;
        int r = h.goldPrice - this.goldPrice;
        if (r != 0) return r;
        r = h.serPrice - this.serPrice;
        if (r != 0) return r;
        r = h.bronzePrice - this.bronzePrice;
        if (r != 0) return r;
        return this.getName().compareTo(h.getName());
    }
}
