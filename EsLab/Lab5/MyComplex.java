public class MyComplex {
    private double real;
    private double imm;
    private final double Epsilon = 1e-14;

    // inizializza il numero complesso al valore 0 + i0 (zero complesso)
    public MyComplex() {
        real = 0;
        imm = 0;
    }

    // inizializza il numero complesso al valore re + i*im
    public MyComplex(double realPart, double imagPart) {
        real = realPart;
        imm = imagPart;
    }

    // Somma a questo numero complesso il numero complesso z
    // somma di due complessi: z = z1+z2 = (x1+x2) + i(y1+y2)
    public MyComplex add(MyComplex z) {
        return new MyComplex(real + z.getRe(), imm + z.getIm());
    }

    // Sottrae a questo numero complesso il numero complesso z
    // sottrazione di due complessi: z = z1-z2 = (x1-x2) +i(y1-y2)
    public MyComplex sub(MyComplex z) {
        return new MyComplex(real - z.getRe(), imm - z.getIm());
    }

    // Moltiplica questo numero complesso per il numero complesso z
    // prodotto di due complessi: z = z1*z2 = (x1*x2 -y1*y2) + i*(x1*y2 + x2*y1)
    public MyComplex mult(MyComplex z) {
        return new MyComplex(real * z.getRe() - imm * z.getIm(), real * z.getIm() - z.getRe() * imm);
    }

    // Divide questo numero complesso per il numero complesso z
    // divisione fra due complessi: z1/z2 = z1 *1/z2, per z2 != 0
    public MyComplex div(MyComplex z) {
        return mult(z.inv());
    }

    // Calcola il coniugato di questo numero complesso
    // coniugato del complesso z: z^= x - i*y
    public MyComplex conj() {
        return new MyComplex(real, -imm);
    }

    // Calcola l'inverso rispetto al prodotto di un numero complesso
    // inverso del complesso z: 1/z = x/(|z|*|z|) -i*y/(|z|*|z|), per z != 0
    public MyComplex inv() {
        return new MyComplex(real / (mod() * mod()), -imm / ((mod() * mod())));
    }

    // Calcola il modulo di questo numero complesso
    // modulo del complesso z: |z| = sqrt( x*x + y*y).
    public double mod() {
        return Math.sqrt(real * real + imm * imm);
    }

    // Confronta con tolleranza due numeri complessi.
    public boolean approxEquals(MyComplex z) {
        return Math.abs(real - z.getRe()) <= Epsilon * Math.max(Math.abs(real), Math.abs(z.getRe())) &&
                Math.abs(imm - z.getIm()) <= Epsilon * Math.max(Math.abs(imm), Math.abs(z.getIm()));
    }

    // Crea una stringa che rappresenta questo numero complesso
    // Formato stringa: parte reale + i*parte immaginaria
    public String toString() {
        return real + " + i*" + imm;
    }

    // Restituisce la parte complessa di un numero complesso
    public double getIm() {
        return imm;
    }

    // Restituisce la parte reale di un numero complesso
    public double getRe() {
        return real;
    }
}