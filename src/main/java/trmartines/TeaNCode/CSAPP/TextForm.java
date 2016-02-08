package trmartines.TeaNCode.CSAPP;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextForm extends JPanel {

  private JTextField[] fields;

//The Formula is as follows:
// Y=(Average * Range) + Minimum
// x=average float value of the 10 skins used
// y=float value of the skins received
// Minimum= minimum of the FV range of the skin received
// Maximum= max of the FV range of the skin received
// range= maximum-minimum
  
  // Create a form with the specified labels, tooltips, and sizes.
  public TextForm(String[] labels, char[] mnemonics, int[] widths, String[] tips) {
    super(new BorderLayout());
    JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
    JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
    add(labelPanel, BorderLayout.WEST);
    add(fieldPanel, BorderLayout.CENTER);
    fields = new JTextField[labels.length];

    for (int i = 0; i < labels.length; i += 1) {
      fields[i] = new JTextField();
      if (i < tips.length)
        fields[i].setToolTipText(tips[i]);
      if (i < widths.length)
        fields[i].setColumns(widths[i]);

      JLabel lab = new JLabel(labels[i], JLabel.RIGHT);
      lab.setLabelFor(fields[i]);
      if (i < mnemonics.length)
        lab.setDisplayedMnemonic(mnemonics[i]);

      labelPanel.add(lab);
      JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
      p.add(fields[i]);
      fieldPanel.add(p);
    }
  }

  public String getText(int i) {
    return (fields[i].getText());
  }

  public static void main(String[] args) {
	//Set name in the JFrame
    String[] labels = { "Skin", "Skin", "Skin", "Skin", "Skin", "Skin", "Skin", "Skin", "Skin", "Skin","Min","Max" }; 
    //Self explanatory sets the mnemonic mainly for recognization
    char[] mnemonics = { '1','2','3','4','5','6','7','8','9','0','Z','A'};
    //Also Self explanatory sets the width of the text box in the JFrame 
    int[] widths = { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15};
    //sets the label for the string
    String[] descs = { "Skin1", "Skin2", "Skin3", "Skin4", "Skin5", "Skin6", "Skin7", "Skin8", "Skin9", "Skin10","Z","A" };

    final TextForm form = new TextForm(labels, mnemonics, widths, descs);

    JButton submit = new JButton("Submit Floats");
    
    
    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  //changes the string that are typed in to doubles
    	  double skin1 = Double.parseDouble(form.getText(1));
    	  double skin2 = Double.parseDouble(form.getText(2));
    	  double skin3 = Double.parseDouble(form.getText(3));
    	  double skin4 = Double.parseDouble(form.getText(4));
    	  double skin5 = Double.parseDouble(form.getText(5));
    	  double skin6 = Double.parseDouble(form.getText(6));
    	  double skin7 = Double.parseDouble(form.getText(7));
    	  double skin8 = Double.parseDouble(form.getText(8));
    	  double skin9 = Double.parseDouble(form.getText(9));
    	  double skin10 = Double.parseDouble(form.getText(0));
    	  double min = Double.parseDouble(form.getText(mnemonics[11]));     	 
    	  double max = Double.parseDouble(form.getText(mnemonics[12]));     	
    	  //gets the Average value for the equation
    	  double average = (skin1 + skin2+ skin3+skin4+skin5+ skin6+ skin7+ skin8+ skin9+ skin10) / 10;
    	  JOptionPane.showMessageDialog(null, average * (min - max)+min);
    	  //JOptionPane.showMessageDialog(null, min);
    	  //JOptionPane.showMessageDialog(null, max);

    	
    	  
      }
    });

    JFrame f = new JFrame("Text Form Example");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(form, BorderLayout.NORTH);
    JPanel p = new JPanel();
    p.add(submit);
    f.getContentPane().add(p, BorderLayout.SOUTH);
    f.pack();
    f.setVisible(true);
    
  }
}
