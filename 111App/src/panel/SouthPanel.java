/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import entity.Practice;
import entity.Topic;
import frame.MainFrameApp;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class SouthPanel extends JPanel implements ItemListener{
    
    private JButton practiceButton; //estaria deshabilitado hasta que se despliega una teoria.
    //esta clase escucharia cuando esta seleccionado un elemento del JList.
    //NOTA: tendria que tener un objeto de tipo practicePanel para setear el id del tema y
    //asi ese panel obtenga el ejercicio correspondiente si coincide con el fk de la bbdd.
    private PracticePanel practicePanel;
    private int idSelectedTopic;
    private MainFrameApp mainFrame;
    private TopicPanel topicPanel;
    private Activity activity;
    private ArrayList<Topic> topics;
    private ArrayList<Practice> practiceList;
    
    public SouthPanel(MainFrameApp mainFrame){
        idSelectedTopic=-1;
        this.practicePanel=mainFrame.getPracticePanel();
        this.mainFrame=mainFrame;
        this.topicPanel=mainFrame.getTopicPanel();
        this.topics=topicPanel.getArrayTopics();
        practiceButton=new JButton("Practicar");
        practiceButton.setEnabled(false);
        practiceButton.addActionListener(mainFrame);
        practiceButton.addActionListener(activity);
        FlowLayout flow=new FlowLayout(FlowLayout.TRAILING);//ver si anda bien eso (invertiria el sentido en el que este gestor añade los componentes)
        setLayout(flow);
        add(practiceButton);
    }
    
    public JButton getPracticeButton(){
    
        return practiceButton;
        
    }
    
    public int getIdSelectedTopic(){
    
        return idSelectedTopic;
        
    }
    
    public void setIdSelectedTopic(int idSelectedTopic){
    
        this.idSelectedTopic=idSelectedTopic;
        
    }
    
    private void loadPracticeArray(int idTopic){
    
        for(Topic t: topics){
        
            if(t.getIdTopic()==idTopic){
            
                practiceList=t.getPractices();//obtengo el conjunto de actividades 
                                              //correspondientes a un tem y lo devuelvo con el get donde lo necesite.
                break;
                
            }
            
        }
        
    }
    
    public ArrayList<Practice> getPracticeList(){
    
       return practiceList; 
       
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        practiceButton.setEnabled(true);
        Topic topicSelected=(Topic)e.getItem();
        loadPracticeArray(topicSelected.getIdTopic());
        
    }
    
}
