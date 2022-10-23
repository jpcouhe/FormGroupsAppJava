package fr.m2i.formation.model;

public class ListPersonne {

    Personne dernierePersonne;

    public static int size = 0;

    private class Personne {
        private Personne suivant;
        private Personne precedent;
        private String name;

        public Personne(Personne precedent, String name){
            this.setPrecedent(precedent);
            this.setName(name);
        }


        public Personne getSuivant() {
            return suivant;
        }

        public void setSuivant(Personne suivant) {
            this.suivant = suivant;
        }

        public Personne getPrecedent() {
            return precedent;
        }

        public void setPrecedent(Personne precedent) {
            this.precedent = precedent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public ListPersonne(){}

    public void add(String name){


        Personne newPersonne = new Personne(dernierePersonne, name);
        if(dernierePersonne != null){
            dernierePersonne.setSuivant(newPersonne);
            newPersonne.setPrecedent(dernierePersonne);
            dernierePersonne = newPersonne;
        } else{
            this.dernierePersonne = new Personne(null, name);
        }

        size++;
    }

    public void delete(int indice){

        Personne currentPersonne = dernierePersonne;
        if(indice < 0 || indice > size) return;



        if(indice == 0 && size != 1) {
            while (currentPersonne.getPrecedent() != null) {
                currentPersonne = currentPersonne.getPrecedent();
            }
            Personne personneSuivante = currentPersonne.getSuivant();
            personneSuivante.setPrecedent(null);
        }else if (indice == 0 && size == 1) {
            dernierePersonne = null;

        }else if(indice == size-1 ){
            currentPersonne = currentPersonne.getPrecedent();
            currentPersonne.setSuivant(null);
            dernierePersonne = currentPersonne;
        }
        else{
            for(int i = size -2 ; i>=indice; i--){
                currentPersonne = currentPersonne.getPrecedent();

            }

            Personne personneSuivante = currentPersonne.getSuivant();
            Personne personnePrecedente = currentPersonne.getPrecedent();

            personneSuivante.setPrecedent(personnePrecedente);
            personnePrecedente.setSuivant(personneSuivante);

        }
        size--;

    }



    public String getOnePersonne(int index){

        if(index < 0 || index > size) return null;

        Personne personneEnCours = dernierePersonne;

        if(index == 0 ){
            while(personneEnCours.getPrecedent() != null){
                personneEnCours = personneEnCours.getPrecedent();
            }

            return personneEnCours.getName();

        }else{
            for(int i = size - 2; i>=index; i--){
                personneEnCours = personneEnCours.getPrecedent();
            }

            return personneEnCours.getName();
        }

    };

    public String printListe(){
        if(size == 0) return "{}";
        String result = " }";
        Personne personneEnCours = dernierePersonne;
        for(int i = size -1; i >= 0; i--){
            result = (i == 0 ? "" : ", ") + personneEnCours.getName() + result;
            personneEnCours = personneEnCours.getPrecedent();
        }
        result = "{ " + result;
        return result;
    }
}
