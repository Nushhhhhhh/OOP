package assesment;

import uk.ac.leedsbeckett.oop.LBUGraphics;

import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class TurtleGraphics extends LBUGraphics{
	
	private Color default_pencolor = Color.WHITE;
	private Color default_bgcolor = Color.BLACK;
	private int default_penwidth = 1;
    private List<String> commandList = new ArrayList<>();
    
    	// Canvas
        public TurtleGraphics() {
            JFrame frame = new JFrame("Turtle Graphics App"); //Create a frame to display the turtle panel on
            frame.setLayout(new FlowLayout());
            frame.add(this); //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
            frame.pack(); //Set the frame to a size we can see
            frame.setVisible(true); //Display it
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make sure the app exits when closed
            
            setPenColour(default_pencolor);
            setStroke(default_penwidth);
            setBackground_Col(default_bgcolor);
        }

    	// Command processing and validation
        public void processCommand(String command) {        	
        	String[] cmd = command.trim().toLowerCase().split(" "); //removes unnecessary spaces converts users input to lower case and split cmd string into array using space
        	commandList.add(command);
        	
        	switch (cmd[0]) {       	
            	case "about":
            		super.about();
            	break; 
            	
            	case "name":
            		about();
            	break;
            	
            	case "penup":
                    drawOff();
                    displayMessage("Pen lifted up."); //Pen doesn't write anymore 
                break;
                    
                case "pendown":
                    drawOn();
                    displayMessage("Pen placed down."); // Pen only write when it is down
                break;
                    
                case "penwidth":
                    if (cmd.length > 1) {
                        try {
                            int width = Integer.parseInt(cmd[1]);
                            if (width > 0) {
                                setStroke(width);
                                displayMessage("Penwidth set to " + width + " pixels.");
                            } else {
                                displayMessage("Penwidth must be positive!");
                            }
                        } catch (NumberFormatException e) {
                            displayMessage("Invalid width! Enter a numeric value.");
                        }
                    } else {
                        displayMessage("Instruction incomplete. Usage: penwidth <width>");
                    }
                break;
                    
                case "move":
                    if (cmd.length > 1) {
                        try {
                            int distance = Integer.parseInt(cmd[1]);
                            if (distance > 0) {
                            	forward(distance);
                            	displayMessage("Moved forward by " + distance + " pixels.");
                            	}
                            else {
                            	displayMessage("Distance must be a positive integer.");
                            }
                        } catch (NumberFormatException e) {
                            displayMessage("Invalid distance! Please enter a numeric value after 'move'.");
                        }
                    } else {
                        displayMessage("Instruction incomplete. Please specify the distance. Usage: move <number>.");
                    }
                break; 
                    
                case "reverse":
                    if (cmd.length > 1) {
                        try {
                            int distance = Integer.parseInt(cmd[1]);
                            if (distance > 0) {
                            	forward(-distance);
                            	displayMessage("Moved backward by " + distance + " pixels.");
                            }
                            else {
                            	displayMessage("Distance must be a positive integer.");                     
                            	}
                        } catch (NumberFormatException e) {
                            displayMessage("Invalid distance! Please enter a numeric value after 'reverse'.");
                        }
                    } else {
                        displayMessage("Instruction incomplete. Please specify the distance. Usage: reverse <number>.");
                    }
                break;
                    
                case "left":
                    if (cmd.length > 1) {
                        try {
                            int angle = Integer.parseInt(cmd[1]);
                            if (angle > 0 && angle <= 360) {
                            	left(angle);
                            	displayMessage("Turned left by " + angle + " degree" );
                            } 
                            else {
                                displayMessage("Angle must be between 1 and 360 degrees.");
                            	}
                        } catch (NumberFormatException e) {
                            displayMessage("Invalid angle! Please enter a numeric value after 'left'.");
                        }
                    } else {
                        displayMessage("Instruction incomplete. Please specify the angle. Usage: left <degrees>.");
                    }
                break;
                    
                case "right":
                    if (cmd.length > 1) {
                        try {
                            int angle = Integer.parseInt(cmd[1]);
                            if (angle > 0 && angle <= 360) {
                            	right(angle);
                            	displayMessage("Turned right by " + angle + " degree" );
                            } else {
                                displayMessage("Angle must be between 1 and 360 degrees.");
                            } 
                        } catch (NumberFormatException e) {
                            displayMessage("Invalid angle! Please enter a numeric value after 'right'.");
                        }
                    } else {
                        displayMessage("Instruction incomplete. Please specify the angle. Usage: right <degrees>.");
                    }
                break;
                    
                //Colors (red,green,blue,yellow,pink,white,black)
                case "color":
                    if (cmd.length > 1) {
                    	switch (cmd[1]) {
                        	case "red":
                        		setPenColour(Color.RED);
                        		displayMessage("Pen color set to red.");
                        		break;
                        	case "green":
                        		setPenColour(Color.GREEN);
                        		displayMessage("Pen color set to green.");
                        	break;
                        	case "blue":
                        		setPenColour(Color.BLUE);
                        		displayMessage("Pen color set to blue.");
                        	break;
                        	case "yellow":
                        		setPenColour(Color.YELLOW);
                        		displayMessage("Pen color set to yellow.");
                        	break;
                        	case "pink":
                        		setPenColour(Color.PINK);
                        		displayMessage("Pen color set to pink.");
                        	break;                    
                        	case "white":
                        		setPenColour(Color.WHITE);
                        		displayMessage("Pen color set to white.");
                        	break;   
                        	case "black":
                        		setPenColour(Color.BLACK);
                        		displayMessage("Pen color set to black.");
                        	break;
                        	default:
                        		displayMessage("Invalid color! Avilable Colors: Red, Green, Blue, Yellow, Pink, White, Black.");
                        	break;
                    	}
                    } else {
                    	displayMessage("Instruction incomplete. Please specify a color. Usage: color <red/green/blue/yellow/pink/white/black>.");                    
                    }
                break; 
                    
                // Color using RGB
                case "pencolor":
                        if (cmd.length > 1) {
                            try {
                                String[] rgb = cmd[1].split(",");
                                if (rgb.length == 3) {
                                    int r = Integer.parseInt(rgb[0].trim());
                                    int g = Integer.parseInt(rgb[1].trim());
                                    int b = Integer.parseInt(rgb[2].trim());
                                    if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
                                        setPenColour(new Color(r, g, b));
                                        displayMessage("Pen color set to RGB(" + r + "," + g + "," + b + ").");
                                    } else {
                                        displayMessage("RGB values must be between 0 and 255!");
                                    }
                                } else {
                                    displayMessage("Instruction incomplete.! Please enter the RGB values. Usage: pencolour <r,g,b>");
                                }
                            } catch (NumberFormatException e) {
                                displayMessage("Invalid RGB values! Enter a numeric value.");
                            }
                        }
                break;
                
                case "bgcolor":
                    if (cmd.length > 1) {
                        switch (cmd[1].toLowerCase()) {
                            case "white":
                                setBackground_Col(Color.WHITE);
                                clear();
                                displayMessage("Background color set to white.");
                            break;
                            case "black":
                                setBackground_Col(Color.BLACK);
                                clear();
                                displayMessage("Background color set to black.");
                            break;
                            case "pink":
                                setBackground_Col(Color.PINK);
                                clear();
                                displayMessage("Background color set to pink.");
                            break;
                            case "gray":
                                setBackground_Col(Color.GRAY);
                                clear();
                                displayMessage("Background color set to gray.");
                            break;
                            default:
                                displayMessage("Invalid color! Try: white, black, pink, gray.");
                            break;
                        }
                    } else {
                        displayMessage("Instruction incomplete. Usage: bgcolor <color>");
                    }
                break;
                
                case "square":
                	drawSquare(cmd);
                break;  
               
                case "triangle":
                	drawTriangle(cmd);
                break;
                        
                case "star":
                	drawStar(cmd);
                break;
                
                case "tree":
                	drawTree();
                	displayMessage("A tree is drawn.");
                break;
                    
                case "saveimg":
                	JFileChooser saveIChooser = new JFileChooser();
                    saveIChooser.setDialogTitle("Save Image As");
                    int saveSelection = saveIChooser.showSaveDialog(null);
                    if (saveSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = saveIChooser.getSelectedFile();
                        String filename = fileToSave.getAbsolutePath();
                        if (!filename.toLowerCase().endsWith(".png")) {
                            filename += ".png";
                        }
                        saveImage(filename);
                    }
                break;
                
                case "loadimg":
                	JFileChooser loadIChooser = new JFileChooser();
                    loadIChooser.setDialogTitle("Load Image");
                    int loadSelection = loadIChooser.showSaveDialog(null);
                    if (loadSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = loadIChooser.getSelectedFile();
                        String filename = fileToOpen.getAbsolutePath();
                        loadImage(filename);
                    }
                break;

                case "savecmd":
                    JFileChooser saveCmdChooser = new JFileChooser();
                    saveCmdChooser.setDialogTitle("Save Commands As");
                    int saveCmdSelection = saveCmdChooser.showSaveDialog(null);
                    if (saveCmdSelection == JFileChooser.APPROVE_OPTION) {
                        File cmdFileToSave = saveCmdChooser.getSelectedFile();
                        String cmdFilename = cmdFileToSave.getAbsolutePath();
                        if (!cmdFilename.toLowerCase().endsWith(".txt")) {
                            cmdFilename += ".txt";
                        }
                        saveCommand(cmdFilename); 
                    }
                    break;

                case "loadcmd":
                    JFileChooser loadCmdChooser = new JFileChooser();
                    loadCmdChooser.setDialogTitle("Load Commands");
                    int loadCmdSelection = loadCmdChooser.showOpenDialog(null);
                    if (loadCmdSelection == JFileChooser.APPROVE_OPTION) {
                        File cmdFileToOpen = loadCmdChooser.getSelectedFile();
                        String cmdFilename = cmdFileToOpen.getAbsolutePath();
                        loadCommand(cmdFilename); 
                    }
                    break;

                case "reset":
                	reset();
                	setPenColour(default_pencolor);
                    setStroke(default_penwidth);
                    setBackground_Col(default_bgcolor);
                    displayMessage("Turtle has been reset.");

            		break;
            		
            	case "clear":
                    clear();
                    displayMessage("Canvas cleared.");
                break;
                    
                default:
                    displayMessage("Invalid command!");
                break;                              
            }             
        }
        
        // Shapes 
        public void drawSquare(String[] cmd) {
        	 if (cmd.length > 1) {
                 try {
                     int size = Integer.parseInt(cmd[1]);
                     if (size > 0) {
                         for (int i = 0; i < 4; i++) {
                             forward(size);
                             right(90);
                         }
                     dance(1);
                     reset();
                     displayMessage("A square with " + size + " pixels sides each.");
                     } else {
                         displayMessage("Size must be positive!");
                     }
                 } catch (NumberFormatException e) {
                     displayMessage("Invalid size! Please enter a numeric value after 'square'.");
                 }
             } else {
                 displayMessage("Instruction incomplete. Usage: square <size>");
             }
        }
        
        public void drawTriangle (String[] cmd){
        	if (cmd.length > 1) {
        		String[] sides= cmd[1].split(",");
        		if (sides.length == 1) {
        			try {
        				int size = Integer.parseInt(sides[0]);
        				if (size > 0) {
        					right(90);
        					for (int i = 0; i < 3; i++) {           
        						forward(size);
        						right(120);
        					}
        					dance(1);
        					displayMessage("Equilateral triangle with side " + size + " pixels.");
                        	} 
        				else {
        					displayMessage("Side must be positive!");
        				}
                    } catch (NumberFormatException e) {
                    	displayMessage("Invalid side! Please enter a numeric value after 'triangle'.");
                    }
        		} else if (sides.length == 3) {
        			try {           	
        				 int side1 = Integer.parseInt(sides[0].trim());
                         int side2 = Integer.parseInt(sides[1].trim());
                         int side3 = Integer.parseInt(sides[2].trim());
                         double a = side1;
                         double b = side2;
                         double c = side3;                                
                         if (a>0 && b>0 && c>0  &&  a + b > c && a + c > b && b + c > a) {
                        	 //double cosA = (b * b + c * c - a * a) / (2 * b * c);
                             double cosB = (a * a + c * c - b * b) / (2 * a * c);
                             double cosC = (a * a + b * b - c * c) / (2 * a * b);
                             //double angle1 = Math.toDegrees(Math.acos(cosA));
                             double angle2 = Math.toDegrees(Math.acos(cosB));
                             double angle3 = Math.toDegrees(Math.acos(cosC));
                             //int turn1 = 180 - (int) angle1;
                             int turn2 = 180 - (int) angle2;
                             int turn3 = 180 - (int) angle3;                             	
                        	 forward(side3);
                             right(turn2);
                             forward(side1);
                             right(turn3);
                             forward(side2);
                             displayMessage("Triangle drawn with sides " + side1 + ", " + side2 + ", " + side3 + " pixels.");
                         } else {
                             displayMessage("Invalid triangle! The given sides do not form a valid triangle.");
                         }
                     } catch (NumberFormatException e) {
                         displayMessage("Invalid sides! Please enter a numeric value after 'triangle'.");
                     }
        		} else {
        	        displayMessage("Instruction incomplete. Usage: triangle <side> or triangle <side1,side2,side3>");
        	    }
        	}
        }
        
        // Extra
        public void drawStar (String[] cmd){
        	if (cmd.length > 1) {
        		try {
        			int size = Integer.parseInt(cmd[1]);
        			if (size > 0) {
        				for (int i = 0; i < 5; i++) {
        					left(145);
        					forward(size);
        				}
        				displayMessage("Star drawn with " + size + "sides each pixels.");
        			} else {
        				displayMessage("The size must be positive!");
        			}
        		} catch (NumberFormatException e) {
        			displayMessage("Invalid size! Please enter a numeric value after 'star'.");
        		}
        	} else {
        		displayMessage("Instruction incomplete. Usage: star <size>");
        	}
        }
        
        public void drawTree() {
        	reset();
            setPenColour(new Color(139, 69, 19));
            setStroke(8);
            forward(120);
            left(180);
            drawOn();
            forward(120);
            
            setStroke(4);
            left(60);
            forward(60);
            forward(-45);
            right(45);
            forward(25);
            forward(-25);
            left(45);
            forward(20);
            left(45);
            forward(25);
            forward(-25);
            right(45);
            forward(-45);
            
            right(60);
            forward(70);
            forward(-45);
            right(45);
            forward(25);
            forward(-25);
            left(45);
            forward(20);
            left(45);
            forward(25);
            forward(-25);
            right(45);
            forward(-60);
            
            right(60);
            forward(65);
            forward(-45);
            right(45);
            forward(25);
            forward(-25);
            left(45);
            forward(20);
            left(45);
            forward(25);
            forward(-25);
            right(45);
            forward(-45);
            
            right(120); 
            forward(30);
            right(120);
            forward(65);
            forward(-45);
            right(45);
            forward(25);
            forward(-25);
            left(45);
            forward(20);
            left(45);
            forward(25);
            forward(-25);
            right(45);
            forward(-45);
            
            drawOff();
            reset();
            forward(70);
            drawOn();
            setStroke(5);
            setPenColour(Color.GREEN);
            
            right(90);
            forward(110);
            right(125);
            forward(65);
            left(120);
            forward(20);
            right(125);
            forward(65);
            left(120);
            forward(20);
            right(125);
            forward(100);
            
            right(90);
            forward(100);
            right(130);
            forward(20);
            left(125);
            forward(70);
            right(130);
            forward(20);
            left(125);
            forward(70);
            right(125);
            forward(110);
        }
        
        // Save and load commands and images
        public void saveImage(String filename) {
            BufferedImage image = getBufferedImage(); 
            
            try {
                File outputFile = new File(filename);
                ImageIO.write(image, "png", outputFile);
                displayMessage("Image saved to " + filename);
            } catch (IOException e) {
                displayMessage("Error saving image: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        public void loadImage(String filename) {
            try {
                BufferedImage image = ImageIO.read(new File(filename));
                if (image != null) {
                   setBufferedImage(image);
                	displayMessage("Image loaded from " + filename);
                } else {
                    displayMessage("Invalid image file.");
                }
            } catch (IOException e) {
                displayMessage("Error loading image: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public void saveCommand(String filename) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                for (String cmd : commandList) { 
                    writer.write(cmd);
                    writer.newLine();
                }
                writer.close();
                displayMessage("Commands saved to " + filename);
            } catch (IOException e) {
                displayMessage("Error saving commands: " + e.getMessage());
            }
        }

        public void loadCommand(String filename) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                while ((line = reader.readLine()) != null) {
                	line = line.trim(); 
                    if (!line.isEmpty()) { 
                    	displayMessage("Command loaded: " + line);
                        System.out.println("Executing: " + line); 
                    	processCommand(line);
                    }
                }
                reader.close();
                displayMessage("Commands loaded from " + filename);
                
            } catch (IOException e) {
                displayMessage("Error loading commands: " + e.getMessage());
            }
        }

        // Name 
        @Override
        public void about() {
        	clear();
        	setTurtleSpeed(1);
        	dance(3);
        	reset(); 
        	setStroke(6);
        	setxPos(15);
        	setyPos(250);
        	
        	// Letter A
        	drawOn();
            setPenColour(Color.BLUE);
        	left(155);
        	forward(150);
        	right(130);
        	forward(150);
        	forward(-65);
        	right(115);
        	forward(70);
        	drawOff();
        	forward(-70);
        	left(115);
        	forward(65);
        	left(65);
        	forward(40);
            
        	// Letter N 
            drawOn();
            setPenColour(Color.RED);
            left(90);
            forward(135);
            right(150);
            forward(160);
            left(150);
            forward(140);
            drawOff();
            forward(-135);
            right(90);
            forward(40);
            left(90);
            forward(30);
            
        	// Letter U
            drawOn();   
            setPenColour(Color.GREEN);
            forward(100);
            forward(-100);
            for (int i = 0; i < 18; i++) {
                forward(-7);
                left(10); 
                } 
            left(180);
            forward(100);
            drawOff();
            forward(-140);
            right(90);
            forward(40);
            left(90);
            forward(30);
            
            // Letter S
            drawOn();
            setPenColour(Color.YELLOW);
            for (int i = 0; i < 26; i++) {
                forward(-6);     
                left(10);      
            }
            for (int i = 0; i < 24; i++) {
                forward(-6);    
                right(10);      
            }  
            drawOff();
            forward(-145);
            right(20);
           
            // Letter K
            drawOn();
            setPenColour(Color.MAGENTA);
            forward(150);
            forward(-80);
            right(50);
            forward(110);
            forward(-110);
            right(80);
            forward(115);
            drawOff();
            left(40);
            forward(40);
            
            // Letter A
            drawOn();
            setPenColour(Color.CYAN);
        	left(70);
        	forward(160);
        	right(135);
        	forward(160);
        	forward(-75);
        	right(115);
        	forward(65);
        	drawOff();  
        	
        	dance(3);
        	reset();
            }       
}