package ept.git.dic2.systeme_vente_velo.controller;//package ept.git.dic2.systeme_vente_velo.controller;

import ept.git.dic2.systeme_vente_velo.beans.EleveBean;
import ept.git.dic2.systeme_vente_velo.model.Eleve;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Random;

@Singleton
@Startup //Pour dire au démarrage de l'application crée l'objet InitEleve
public class EleveInit {
    @EJB
    private EleveBean eleveFacade;
    @PersistenceContext(name = "dic2PU")
    private EntityManager entityManager;
    public EleveInit() {
    }
    @PostConstruct // Pour dire qu'une fois qu'on crée initEleve execute automatiquement la méthode Init
    public void Init() {

        String[] prenoms={"Fatou","Bass","Khady"};
        String[] noms={"Diop","Mbodj","Pouye"};
        Random rand = new Random();
        int nbreEleve = 20;
        for (int i = 0; i <nbreEleve ; i++) {
            String prenom = prenoms[rand.nextInt(prenoms.length)];
            String nom =noms[rand.nextInt( noms.length)];
            double poids=rand.nextDouble()*50+50;
            String numero="dic2_"+(i+1);
            Eleve eleve = new Eleve(numero,prenom,nom,poids);
            eleveFacade.create(eleve);
            // Le if fait en sorte que S'il ya des données au niveau de la table la table ne sera pas recréé
            /*if(eleveFacade.count()>0){
                return;
            }

             */
        }

        System.out.println("Initialisation des élèves");


    }


}

