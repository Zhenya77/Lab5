package Dragon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * create new human
 *
 * @author Diana
 */
public class Dragonborn {
    public static boolean isFromScript;
    Scanner scanner = new Scanner(System.in);
    String whyFailed = "";
    public static Dragon dragonFromScript;
    /**
     * Reads input and therefore creates new human
     *
     * @return new human object
     */
    public Dragon create() {
        Dragon dragon = new Dragon();
        this.setName(dragon);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateX(coordinates);
        this.setCoordinateY(coordinates);
        dragon.setCoordinates(coordinates);
        this.setAge(dragon);
        this.setDescription(dragon);
        this.setSpeaking(dragon);
        this.setColor(dragon);
        Person killer = new Person();
        this.setPersonName(killer);
        this.setHeight(killer);
        this.setEyeColor(killer);
        this.setHairColor(killer);
        dragon.setKiller(killer);
        dragon.setCreationDate(LocalDate.now());
        return dragon;
    }

    public void createFromFile(Object pars) {
        try {
            ArrayList<String> params = (ArrayList) pars;
            Dragon dragon = new Dragon();
            this.setName(dragon, params.get(0));
            Coordinates coordinates = new Coordinates();
            this.setCoordinateX(coordinates, params.get(1));
            this.setCoordinateY(coordinates, params.get(2));
            dragon.setCoordinates(coordinates);
            this.setAge(dragon, params.get(3));
            this.setDescription(dragon, params.get(4));
            this.setSpeaking(dragon, params.get(5));
            this.setColor(dragon, params.get(6));
            Person killer = new Person();
            this.setPersonName(killer, params.get(7));
            this.setHeight(killer, params.get(8));
            this.setEyeColor(killer, params.get(9));
            this.setHairColor(killer, params.get(10));
            dragon.setKiller(killer);
            dragon.setCreationDate(LocalDate.now());
            dragonFromScript = dragon;
            isFromScript = true;
        } catch (Exception e) {
            System.out.println(whyFailed);
            whyFailed = "";
        }
    }

    public void setName(Dragon dragon) {
        System.out.println("Введите имя дракона:");
        System.out.print("~ ");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals(null)) this.setName(dragon);
        dragon.setName(name);
    }

    public void setCoordinateX(Coordinates coords) {
        try {
            System.out.println("Введите координату x:");
            System.out.print("~ ");
            String x = scanner.nextLine();
            if (x.equals("") || x.equals(null)) this.setCoordinateX(coords);
            double xn = Double.parseDouble(x);
            if (xn <= 364) coords.setX(xn);
            else {
                System.out.println("Значение должно быть меньше 364");
                this.setCoordinateX(coords);
            }
            coords.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"double\".");
            this.setCoordinateX(coords);
        }
    }

    public void setCoordinateY(Coordinates coords) {
        try {
            System.out.println("Введите координату y:");
            System.out.print("~ ");
            String y = scanner.nextLine();
            if (y.equals("") || y.equals(null)) this.setCoordinateY(coords);
            coords.setY(Float.parseFloat(y));
            float yn = Float.parseFloat(y);
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Значение должно быть типа:\"float\".");
            this.setCoordinateY(coords);
        }
    }

    public void setAge(Dragon dragon) {
        try {
            System.out.println("Введите возраст дракона:");
            System.out.print("~ ");
            String age = scanner.nextLine();
            if (age.equals("")) this.setAge(dragon);
            long agel = Long.parseLong(age);
            if (agel > 0) dragon.setAge(agel);
            else System.out.println("Значение должно быть положительным.");
        } catch (Exception e) {
            System.out.println("Значение должно быть типа:\"long\".");
            this.setAge(dragon);
        }
    }

    public void setDescription(Dragon dragon) {
        System.out.println("Введите описание дракона.");
        System.out.print("~ ");
        String des = scanner.nextLine();
        if (des.equals("") || des.equals(null)) this.setDescription(dragon);
        else dragon.setDescription(des);
    }

    public void setSpeaking(Dragon dragon) {
        System.out.println("Введите есть ли у дракона способность разговаривать(true/false):");
        System.out.print("~ ");
        String speaking = scanner.nextLine();
        if (speaking.equals(""))
            dragon.setSpeaking();
        else if (speaking.equals("true") || speaking.equals("false"))
            dragon.setSpeaking(Boolean.parseBoolean(speaking));
        else {
            System.out.println("Значение должно быть типа:\"boolean\"");
            this.setSpeaking(dragon);
        }

    }

    public void setColor(Dragon dragon) {
        System.out.println("Введите расцветку дракона(GREEN, RED, BLUE, ORANGE, BROWN):");
        System.out.print("~ ");
        String color = scanner.nextLine().toUpperCase();
        try {
            dragon.setColor(Color.valueOf(color));
        } catch (Exception e) {
            System.out.println("Значение должно соответствовать перечислинным типам. Введите значение:");
            this.setColor(dragon);
        }
    }

    public void setPersonName(Person killer) {
        System.out.println("Введите имя убийцы:");
        System.out.print("~ ");
        String name = scanner.nextLine();
        if (name.equals("") || name.equals(null)) this.setPersonName(killer);
        killer.setName(name);
    }

    public void setHeight(Person killer) {
        try {
            System.out.println("Введите рост убийцы:");
            System.out.print("~ ");
            String height = scanner.nextLine();
            if (height.equals("")) this.setHeight(killer);
            float heightf = Float.parseFloat(height);
            if (heightf > 0) killer.setHeight(heightf);
            else System.out.println("Значение должно быть положительным.");
        } catch (Exception e) {
            System.out.println("Значение должно быть типа:\"float\".");
            this.setHeight(killer);
        }
    }

    public void setEyeColor(Person killer) {
        System.out.println("Введите цвет глаз убийцы(GREEN, RED, BLUE, ORANGE, BROWN):");
        System.out.print("~ ");
        String color = scanner.nextLine().toUpperCase();
        try {
            killer.setEyeColor(Color.valueOf(color.toUpperCase()));
        } catch (Exception e) {
            System.out.println("Значение поля должно соответствовать перечислинным типам");
            this.setEyeColor(killer);
        }
    }

    public void setHairColor(Person killer) {
        System.out.println("Введите цвет волос убийцы(GREEN, RED, BLUE, ORANGE, BROWN):");
        System.out.print("~ ");
        String color = scanner.nextLine().toUpperCase();
        try {
            killer.setHairColor(Color.valueOf(color.toUpperCase()));
        } catch (Exception e) {
            System.out.println("Значение поля должно соответствовать перечислинным типам.");
            this.setHairColor(killer);
        }
    }

    public void setName(Dragon dragon, String name) throws Exception {
        if (name.equals("") || name.equals(null)) {
            whyFailed += "У дракона должно быть имя.\n";
            throw null;
        } else dragon.setName(name);
    }

    public void setCoordinateX(Coordinates coords, String x) throws Exception {
        try {
            if (x.equals("") || x.equals(null)) whyFailed += "У дракона должна быть координата x.\n";
            ;
            double xn = Double.parseDouble(x);
            if (xn <= 364) coords.setX(xn);
            else {
                whyFailed += ("Значение координаты х должно быть меньше 364.\n");
                throw null;
            }
            coords.setX(xn);
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += ("Значение должно быть типа:\"double\".\n");
            throw new Exception();
        }
    }

    public void setCoordinateY(Coordinates coords, String y) throws Exception {
        try {
            if (y.equals("") || y.equals(null)) {
                whyFailed += "У дракона должна быть коордната y.\n";
                throw null;
            }
            coords.setY(Float.parseFloat(y));
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += ("Значение координаты y должно быть типа:\"float\".\n");
            throw new Exception();
        }
    }


    public void setAge(Dragon dragon, String age) {
        try {
            if (age.equals("")) {
                whyFailed += "У дракона должен быть возраст.\n";
                throw null;
            }
            long agel = Long.parseLong(age);
            if (agel > 0) dragon.setAge(agel);
            else {
                whyFailed += ("Значение возраста должно быть положительным.\n");
                throw null;
            }
        } catch (InputMismatchException | NumberFormatException e) {
            whyFailed += ("Значение возраста должно быть типа:\"long\"");
            throw null;
        }
    }

    public void setDescription(Dragon dragon, String des) {
        if (des.equals("") || des.equals(null)) {
            whyFailed += "У дракона должно быть описание";
        } else dragon.setDescription(des);
    }

    public void setSpeaking(Dragon dragon, String speaking) {
        if (speaking.equals(""))
            dragon.setSpeaking();
        else if (speaking.equals("true") || speaking.equals("false"))
            dragon.setSpeaking(Boolean.parseBoolean(speaking));
        else {
            whyFailed += ("Значение способности разговаривать должно быть типа:\"boolean\".\n");
            throw null;
        }

    }

    public void setColor(Dragon dragon, String color) {
        try {
            dragon.setColor(Color.valueOf(color.toUpperCase()));
        } catch (Exception e) {
            whyFailed += ("Значение расцетки должно соответствовать перечислинным типам(GREEN, RED, BLUE, ORANGE, BROWN).\n:");
            this.setColor(dragon);
        }
    }

    public void setPersonName(Person killer, String name) {
        if (name.equals("") || name.equals(null)) {
            whyFailed += ("У убийцы должно быть имя.\n:");
            throw null;
        } else killer.setName(name);
    }

    public void setHeight(Person killer, String height) {
        try {
            if (height.equals("")) {
                whyFailed += ("У убийцы должен быть рост.\n:");
                throw null;
            }
            float heightf = Float.parseFloat(height);
            if (heightf > 0) killer.setHeight(heightf);
            else {
                whyFailed += ("Значение роста убийцы должно быть положительным.\n");
                throw null;
            }
        } catch (Exception e) {
            whyFailed += ("Значение роста убийцы должно быть типа:\"float\".\n");
            throw null;
        }
    }

    public void setEyeColor(Person killer, String color) {
        try {
            killer.setEyeColor(Color.valueOf(color.toUpperCase()));
        } catch (Exception e) {
            whyFailed += ("Значение поля цвета глаз убийцы должно соответствовать перечислинным типам(GREEN, RED, BLUE, ORANGE, BROWN)\n");
            throw null;
        }
    }

    public void setHairColor(Person killer, String color) {
        try {
            killer.setHairColor(Color.valueOf(color.toUpperCase()));
        } catch (Exception e) {
            whyFailed += ("Значение поля цвета волос убийцы должно соответствовать перечислинным типам(GREEN, RED, BLUE, ORANGE, BROWN)\n");
            throw null;
        }
    }
}