public class Cerchio {
    private Punto centro;
    private double raggio;

    public Cerchio(Punto centro, double raggio) {
        this.centro = centro;
        this.raggio = raggio;
    }

    public boolean interno(Cerchio altroCerchio) {
        double distanzaCentri = centro.distanza(altroCerchio.centro);
        double differenzaRaggi = raggio - altroCerchio.raggio;
        return distanzaCentri < differenzaRaggi;
    }

    public boolean tangenteInterno(Cerchio altroCerchio) {
        double distanzaCentri = centro.distanza(altroCerchio.centro);
        double differenzaRaggi = raggio - altroCerchio.raggio;
        return distanzaCentri == differenzaRaggi;
    }

    public boolean secante(Cerchio altroCerchio) {
        double distanzaCentri = centro.distanza(altroCerchio.centro);
        double differenzaRaggi = raggio - altroCerchio.raggio;
        double sommaRaggi = raggio + altroCerchio.raggio;
        return distanzaCentri > differenzaRaggi && distanzaCentri < sommaRaggi;
    }

    public boolean tangenteEsterno(Cerchio altroCerchio) {
        double distanzaCentri = centro.distanza(altroCerchio.centro);
        double sommaRaggi = raggio + altroCerchio.raggio;
        return distanzaCentri == sommaRaggi;
    }

    public boolean esterno(Cerchio altroCerchio) {
        double distanzaCentri = centro.distanza(altroCerchio.centro);
        double sommaRaggi = raggio + altroCerchio.raggio;
        return distanzaCentri > sommaRaggi;
    }
}
