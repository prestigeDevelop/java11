package codingInterview;

import java.time.LocalTime;

public class ReverseCStyleString {
    public static void main(String[] args) {
        String name = "Hello , \n" +
                "My name is Avi ,\n" +
                " I reach out to query about used engine oil ?\n" +
                "One of my biggest customers from Europe is interested in buying used engine oil.\n" +
                " We want to buy at list 5000 Ton per month  \n" +
                "Do you have used engine oil for sale which similar the following criteria:\n" +
                " \n" +
                " ---------------------------------------------------------\n" +
                "Free fatty acids 3 % Max\n" +
                "M.I.U(Moisture and Impurities) 0.1 % max\n" +
                "Saponification value: 18185-1955-195\n" +
                "Iodine value: 120\n" +
                "Titre C (melting point) 13.75 C\n" +
                "Specific Gravity a 25 C 0.915\n" +
                "Density (kg/m3) 920\n" +
                "Flashpoint by P.-M. (Degree C) 220\n" +
                "Calorific Value (kj/kg) 36,000\n" +
                "Kinematic Viscosity (40 deg.C) (mm2/s)\n" +
                "Carbon Residue (mass-%) 0.4\n" +
                "Sulphur Content (mg/kg) 18\n" +
                "Contamination (mg/kg) 24\n" +
                "Acid Value (mg KOH)/g) 7.0\n" +
                "Oxidation Stability (110 deg.C)(h) 5.0 (min)\n" +
                "Phosphorus Content (mg/kg) 15\n" +
                "Ash Content (mass %) 0.01\n" +
                "------------------------------------------------------------------------------------------------------------------------\n" +
                " \n" +
                "If so, we would like to have:\n" +
                "•\tPrice (CIF)\n" +
                "•\tFrom which port its depart.\n" +
                "•\tWhat is the monthly/annual quantity that can be provided\n" +
                "•\tSpecification\n" +
                " \n" +
                "Thanks and regards\n" +
                "Avi Gold\n" +
                "M:902-223-7899\n" +
                "\n" +
                "\n" +
                "\n" +
                "Hello , \n" +
                "My name is Avi ,\n" +
                " I reach out to query about used engine oil ?\n" +
                "One of my biggest customers from Europe is interested in buying used engine oil.\n" +
                "The preferred quantity would be around 5000 MT/m per month. \n" +
                "Do you have used engine oil for sale which similar the following criteria:\n" +
                " \n" +
                " ---------------------------------------------------------\n" +
                "Free fatty acids 3 % Max\n" +
                "M.I.U(Moisture and Impurities) 0.1 % max\n" +
                "Saponification value: 18185-1955-195\n" +
                "Iodine value: 120\n" +
                "Titre C (melting point) 13.75 C\n" +
                "Specific Gravity a 25 C 0.915\n" +
                "Density (kg/m3) 920\n" +
                "Flashpoint by P.-M. (Degree C) 220\n" +
                "Calorific Value (kj/kg) 36,000\n" +
                "Kinematic Viscosity (40 deg.C) (mm2/s)\n" +
                "Carbon Residue (mass-%) 0.4\n" +
                "Sulphur Content (mg/kg) 18\n" +
                "Contamination (mg/kg) 24\n" +
                "Acid Value (mg KOH)/g) 7.0\n" +
                "Oxidation Stability (110 deg.C)(h) 5.0 (min)\n" +
                "Phosphorus Content (mg/kg) 15\n" +
                "Ash Content (mass %) 0.01\n" +
                "------------------------------------------------------------------------------------------------------------------------\n" +
                " \n" +
                "If so, we would like to have:\n" +
                "•\tPrice (CIF)\n" +
                "•\tFrom which port its depart.\n" +
                "•\tWhat is the monthly/annual quantity that can be provided\n" +
                "•\tSpecification\n" +
                " \n" +
                "Thanks and regards\n" +
                "Avi Gold\n" +
                "M:902-223-7899\n" +
                "Nova Scotia,Canada\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "I am interested in your products. Please contact me back on email/phone.\n" +
                "The preferred quantity would be around 5000 MT/m per month. \n" +
                "If so, we would like to have:\n" +
                "•\tPrice (CIF)\n" +
                "•\tFrom which port its depart.\n" +
                "•\tWhat is the monthly/annual quantity that can be provided\n" +
                "•\tSpecification\n" +
                "\n" +
                "**********************************************************************\n" +
                "Hello ,\n" +
                "One of my biggest customers  is interested in buying used engine oil.\n" +
                "Can you provide more information please:\n" +
                "1.\tPrice (CIF)\n" +
                "2.\tFrom which port its depart.\n" +
                "3.\tWhat is the monthly quantity that can be provided\n" +
                "4.\tSpecification\n" +
                " \n" +
                "Thanks and regards\n" +
                "Avi Gold\n" +
                "M:902-223-7899\n" +
                "Nova Scotia,CanadaABCDfgfdghfdhsgfhgsfhsgfshgfhgfshfghgfhsfghsfghgfhgfhgfhtrhhfghgfhrthhfghrthytrhfghrtyhrthrt5ert6t5465634534534terty54ty6ty5t4ry54bhy54y546hy5y56yn65jy65jy6j565hy65hy65y65ygh65y6jhyh65y65y6y65hy65yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyu7yikuooiuouio87786i87oi8ouoiuoi9ouilljil";
        String result = "";
        LocalTime start = LocalTime.now();
        for (int i = name.length() - 1; i >= 0; i--) {
            char c = name.charAt(i);
            result += c;
        }
        LocalTime after = LocalTime.now();
        int hour=after.getHour() - start.getHour();
        int minute=after.getMinute() - start.getMinute();
        int second=after.getSecond() - start.getSecond();
        int nano=after.getNano() - start.getNano();
        System.out.println("Time: " + hour +"," +minute+ "," + second + "," + nano);
        //System.out.println(result);
    }
}
