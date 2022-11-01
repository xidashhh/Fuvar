package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static List<Fuvar> fuvarok;

    public static void main(String[] args) {
        String file = "fuvar.csv";
        try {
            beolvas(file);
//            for (Fuvar i:fuvarok) {
//                System.out.println(i);
//            }

            System.out.printf("Osszesen %d utazas kerult feljegyzesre.\n", fuvarok.stream().count());

            System.out.printf("6185-os sofor %d fuvar %s bevetel.\n", fuvarok.stream().filter(fuvarok -> fuvarok.getAzonosito() == 6185).count(),
                    fuvarok.stream().filter(fuvarok -> fuvarok.getAzonosito() == 6185).mapToDouble(Fuvar::getOsszBevetel).sum());

            System.out.printf("Osszezen %s merfoldet tettek meg a taxisok.\n", fuvarok.stream().mapToDouble(Fuvar::getMegtettTavolsag).sum());

            System.out.printf("Leghosszabb fuvar adatai: %s\n", fuvarok.stream().max(Comparator.comparingInt(Fuvar::getIdotartam)));

            System.out.printf("Legbokezubb: %s\n", fuvarok.stream().max(Comparator.comparingDouble(Fuvar::getArany)));

            System.out.printf("4261-es taxis %s kilometert tett meg\n", fuvarok.stream()
                    .filter(fuvarok -> fuvarok.getAzonosito() == 4261)
                    .mapToDouble(Fuvar::getMegtettTavolsag)
                    .sum()*1.6);

            System.out.printf("Szerepel-e 1452-es fuvar: %s\n", fuvarok.stream().anyMatch(fuvarok -> fuvarok.getAzonosito() == 1452));

            System.out.printf("December 24-en %s fuvar volt\n", fuvarok.stream()
                    .filter(fuvarok -> fuvarok.getIndulasIdopont().contains("2016-12-24")).count());

            System.out.println("December 31-én a borravalók aránya: ");
            List<Double> borravalok=fuvarok.stream()
                    .filter(fuvar -> fuvar.getIndulasIdopont().contains("2016-12-31"))
                    .map(Fuvar::getArany)
                    .collect(Collectors.toList());
            borravalok.forEach(System.out::println);

        }
        catch (IOException e) {
        System.out.printf("Hiba történt a(z) %s fájl beolvasása során", file);
        }
    }

    public static void beolvas(String fajlNev) throws IOException{
        fuvarok = new ArrayList<>();

        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);

        String fejlec = br.readLine();

        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()){
            String[] adatok = sor.replace(",", ".").split(";");
            Fuvar i = new Fuvar(Integer.parseInt(adatok[0]),
                    adatok[1],
                    Integer.parseInt(adatok[2]),
                    Double.parseDouble(adatok[3]),
                    Double.parseDouble(adatok[4]),
                    Double.parseDouble(adatok[5]),
                    adatok[6]);

            fuvarok.add(i);
            sor = br.readLine();
        }

        br.close();
        fr.close();
    }
}