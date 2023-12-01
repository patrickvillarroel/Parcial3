import java.io.*;

class Interseccion {
    private int[][] arr;
    private int calle, avenida;

    // Constructor y metodos
    public Interseccion(int f, int c) {
        arr = new int[f][c];

    }

    public void asignarDatos(int c, int a) {
        calle = c;
        avenida = a;
    }

    public int devolverCalle() {
        return calle;
    }

    public int devolverAvenida() {
        return avenida;
    }

    public int SumarElemento() {
        arr[(avenida - 1)][(calle - 1)]++;
        return arr[(avenida - 1)][(calle - 1)];
    }

    public int sumarTodos() {
        int suma = 0;
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 10; j++) {
                suma += arr[i][j];
            }
        }
        return suma;
    }

    public int sumarFilas(int k) {
        int i, j;
        int suma[] = new int[arr.length];
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 10; j++) {
                suma[i] += arr[i][j];
            }
        }
        return suma[k];
    }

    public int CompararMayor() {
        int i, mayor = 0, mayorAv = 0;
        for (i = 0; i < 3; i++) {
            if (mayor < sumarFilas(i)) {
                mayor = sumarFilas(i);
            }
        }
        for (i = 0; i < 3; i++) {
            if (mayor == sumarFilas(i)) {
                mayorAv = i + 1;
            }
        }
        return mayorAv;
    }

    public int mostrar_elemento(int f, int c) {
        return arr[f][c];
    }

}

public class Avenida {
    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, calle = 0, avenida = 0, opcion = 0;
        Interseccion obj = new Interseccion(3, 10);

        try {
            System.out.println("Cuantos accidentes desea registrar?");
            opcion = Integer.parseInt(br.readLine());
            for (i = 0; i < opcion; i++) {
                System.out.println("En donde ocurrio el accidente?");
                System.out.println("Avenida: ");
                avenida = Integer.parseInt(br.readLine());
                System.out.println("Calle: ");
                calle = Integer.parseInt(br.readLine());
                obj.asignarDatos(calle, avenida);
                obj.SumarElemento();
            }

        } catch (IOException ex) {
            System.out.println("Error de entrada");
        }

        for (i = 0; i < 3; i++) {
            System.out.println("Avenida" + (i + 1) + ": " + obj.sumarFilas(i));
        }
        System.out.println("Avenida con mas accidentes: " + obj.CompararMayor());

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(obj.mostrar_elemento(i, j) + "\t"); // "\t" agrega un tabulador
            }
            System.out.println(); // Nueva línea después de cada fila
        }

    }
}
