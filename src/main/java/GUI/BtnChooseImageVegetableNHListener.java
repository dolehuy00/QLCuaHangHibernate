
package GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BtnChooseImageVegetableNHListener extends MouseAdapter{
    NhapHangVegetableGUI context;
    
    public BtnChooseImageVegetableNHListener(NhapHangVegetableGUI context){
        this.context = context;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPG & PNG Images","jpg","png"));
        int res = fileChooser.showOpenDialog(context.pnl_input);
        String path = new File("").getAbsolutePath();
        if (res == JFileChooser.APPROVE_OPTION) {
            File imageFilePath = new File(fileChooser.getSelectedFile().getAbsolutePath());
            String nameImage = fileChooser.getSelectedFile().getName();
            context.lbl_input_image.setText("images/"+nameImage);
            try {
                BufferedImage bufferedImage = ImageIO.read(imageFilePath);
                File outputfile = new File(path+"\\src\\main\\resources\\img\\"+nameImage);
                ImageIO.write(bufferedImage, "jpg", outputfile);
            } catch (IOException iOException) {
                System.err.println(iOException);
            }
        }
    } 
}
