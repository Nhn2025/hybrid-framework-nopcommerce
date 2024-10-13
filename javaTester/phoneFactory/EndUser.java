package phoneFactory;

public class EndUser {

    public static void main(String[] args) {
        PhoneFactory phone;
        phone = getPhone("iPhone");
        phone.setPhoneName("iPhone 14 Pro");
        System.out.println(phone.getPhoneName());

        phone = getPhone("Samsung");
        phone.setPhoneName("Samsung S23");
        System.out.println(phone.getPhoneName());

        phone = getPhone("Reno");
        phone.setPhoneName("Reno 123");
        System.out.println(phone.getPhoneName());
    }

    public static PhoneFactory getPhone(String phoneType) {
        PhoneFactory phoneFactory = null;

        if (phoneType.equals("iPhone"))
            phoneFactory = new IPhone();
        else if (phoneType.equals("SamSung"))
            phoneFactory = new SamSung();
        else if (phoneType.equals("Reno"))
            phoneFactory = new Reno();

        return phoneFactory;
    }

}
