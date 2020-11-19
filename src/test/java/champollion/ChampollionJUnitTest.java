package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Intervention coursA;
        Intervention coursB;
        Salle b102;
        Date dateA;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                b102 = new Salle("B102", 40);
                dateA = new Date(2020, 11, 19);
                coursA = new Intervention(b102,uml,untel,dateA,2);
                coursB = new Intervention(b102,java,untel,dateA,2);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testAjouteIntervention() {
            //ajout d'une nouvelle intervention pour l'enseignant untel
            untel.ajouteIntervention(coursA);
            
            assertEquals(coursA, untel.getInterventions().get(0),
                    "L'enseignant doit avoir une intervention coursA");
        }
	
        @Test
        public void testHeuresPlanifiees() throws Exception{
            untel.ajouteIntervention(coursA);
            untel.ajouteIntervention(coursB);
            coursB.annulerIntervention();
            
            assertEquals(2, untel.heuresPlanifiees(),
                    "L'enseignant doit avoir 2h planifiées");
        }
        
        @Test
        public void testSousService(){
            //ajout d'un service < 192h équivalentTD
            untel.ajouteEnseignement(uml, 12, 4, 8);
            assertTrue(untel.enSousService(),
                    "L'enseignant doit être en sous-service");
            
            //ajout d'un service pour faire passer le nombre d'heures de l'enseignant en équivalents TD à plus de 192
            untel.ajouteEnseignement(java, 70, 100, 60);
            assertEquals(278, untel.heuresPrevues(),
                    "L'enseignant doit avoir 278 heures prévues");
            assertFalse(untel.enSousService(),
                    "L'enseignant ne doit pas être en sous-service");
        }
}
