package Services;

public class BankInfo {
    private final String name;
    private final String bic;
    private final String city;
    private final int plz;

    public BankInfo(String name, String bic, String city, int plz) {
        this.name = name;
        this.bic = bic;
        this.city = city;
        this.plz = plz;
    }

    public String getName() {
        return name;
    }

    public String getBic() {
        return bic;
    }

    public String getCity() {
        return city;
    }

    public int getPlz() {
        return plz;
    }

    @Override
    public String toString() {
        return ("Name of Bank:\t" + name + "\nBic:\t\t\t" + bic + "\nCity:\t\t\t" + city + "\nPLZ:\t\t\t" + plz);
    }
}
