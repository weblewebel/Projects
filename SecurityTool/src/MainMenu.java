import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import java.awt.Desktop;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class MainMenu {
	
	//These are the variables needed for the text encryption and decryption.  
	private static Text text;
	private static Text text_1;
	private static Text text_2;
	
	//These are the variables needed for the file encryption and decryption. 
	private static Text text_3;
	private static Text text_4;
	private static Text text_5;
	
	//These are the variables needed for the Image and folder encryption and decryption with the password. 
	private static Cipher encrypt;
	private static Cipher decrypt;
	private static Text text_6;
	private static Text text_7;
	private static Text text_8;
	private static Text text_9;
	private static Text text_11;
	private static Text text_12;
	public static String First_pass;
	public static String theFile;
	
	
	// These are the classes need for the encryption and decrytion of the image
	private static void encrypt(InputStream input, OutputStream output)
			throws IOException {
			output = new CipherOutputStream(output, encrypt);
			writeBytes(input, output);
		}
	
	private static void decrypt(InputStream input, OutputStream output) throws IOException {
			input = new CipherInputStream(input, decrypt);
			writeBytes(input, output);
		}
	
	private static void writeBytes(InputStream input, OutputStream output)throws IOException {
			byte[] writeBuffer = new byte[512];
			int readBytes = 0;
			while ((readBytes = input.read(writeBuffer)) >= 0) {
			output.write(writeBuffer, 0, readBytes);
		}
			
				output.close();
				input.close();
		}
	
	// This is the method used to zip the folder before going through the encryption 
	 private static void zipFile(final File fileToZip, final String filePath, final ZipOutputStream zipOut) throws IOException {

	        if (fileToZip.isHidden()) {
	            return;
	        }
	        if (fileToZip.isDirectory()) {
	            final File[] children = fileToZip.listFiles();
	            for (final File childFile : children) {
	                zipFile(childFile, filePath + "/" + childFile.getName(), zipOut);
	            }
	            return;
	        }
	        final FileInputStream fis = new FileInputStream(fileToZip);
	        final ZipEntry zipEntry = new ZipEntry(filePath);
	        zipOut.putNextEntry(zipEntry);
	        final byte[] bytes = new byte[1024];
	        int length;
	        while ((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }
	        fis.close();
	    }
	
	//This is the class used to encrypt both image and folder using AES/ECB/PKC5Padding 
	public static byte[] encryptImageandFolder(Key key, byte[] content) {
		Cipher cipher;
		byte[] encrypted = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypted = cipher.doFinal(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encrypted;
	}
	//This is the class used to decrypt both image and folder using AES/ECB/PKC5Padding
	public static byte[] decryptImageandFolder(Key key, byte[] textCryp) {
		Cipher cipher;
		byte[] decrypted = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypted = cipher.doFinal(textCryp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decrypted;
	}
	
	 public static void unZip(){
         String dest = "M:\\new folder\\Decrypted Folder";
         String zipSource = "M:\\new folder\\Decrypted Folder.zip";
         
         	File dir = new File(dest);
         	if(!dir.exists()) dir.mkdirs();
         	FileInputStream fis;
         	byte[] buffer = new byte[1024];
         	try {
         		fis = new FileInputStream(zipSource);
         		ZipInputStream zis = new ZipInputStream(fis);
         		ZipEntry ze = zis.getNextEntry();
         		while(ze != null){
         			
         			String filePath = ze.getName();
         			File newFile = new File(dest + File.separator + filePath);
         			new File(newFile.getParent()).mkdirs();
         			FileOutputStream fos = new FileOutputStream(newFile);
         			int length;
         			
         			while ((length = zis.read(buffer)) > 0) {
         				fos.write(buffer, 0, length);
         			}
         			fos.close();
         			zis.closeEntry();
         			ze = zis.getNextEntry();
         		}
					zis.closeEntry();
					zis.close();
					fis.close();
					} catch (IOException e) {
					e.printStackTrace();
					}
	 			}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		
		//This is the encryption method used for the text input and text file encryption
		byte[] keyBytes = new byte[] { 0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd,
				(byte) 0xef };
		byte[] ivBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};
	
		final SecretKeySpec key1 = new SecretKeySpec(keyBytes, "DES");
		final IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		
		
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		Key key = keyGenerator.generateKey();
		


	//This coding is used for the display and SWT elements of the application
		Display display = Display.getDefault();
		Shell shlComputerSecurityTool = new Shell();
		shlComputerSecurityTool.setBackground(SWTResourceManager.getColor(SWT.DRAW_TRANSPARENT));
		shlComputerSecurityTool.setImage(SWTResourceManager.getImage("M:\\eclipse-neon\\SecurityTool\\icon.png"));
		shlComputerSecurityTool.setSize(652, 447);
		shlComputerSecurityTool.setText("Computer Security Tool");
			
		TabFolder tabFolder = new TabFolder(shlComputerSecurityTool, SWT.NONE);
		tabFolder.setBounds(10, 44, 592, 287);
		
		TabItem tbtmText = new TabItem(tabFolder, SWT.NONE);
		tbtmText.setText("Text");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmText.setControl(composite);
		
		text = new Text(composite, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.NORMAL));
		text.setBounds(125, 30, 265, 28);
		
		Label lblInputText = new Label(composite, SWT.NONE);
		lblInputText.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblInputText.setText("Input Text");
		lblInputText.setBounds(49, 33, 75, 28);
		
		Label lblEncrypt = new Label(composite, SWT.NONE);
		lblEncrypt.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblEncrypt.setBounds(49, 93, 55, 15);
		lblEncrypt.setText("Encrypt");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.NORMAL));
		text_1.setBounds(125, 90, 265, 28);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.NORMAL));
		text_2.setBounds(125, 147, 265, 28);
		
		Label lblDecrypt = new Label(composite, SWT.NONE);
		lblDecrypt.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblDecrypt.setBounds(49, 149, 55, 15);
		lblDecrypt.setText("Decrypt");
//-------------------------------------------- Text Input -------------------------------------------------------------------------------------------		
		
	//This is the button for encrypting the text within the SWT application
		Button btnEncryptText = new Button(composite, SWT.NONE);
		btnEncryptText.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnEncryptText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//get input text to be encrypted from the text bar named text
					byte[] input = text.getText().getBytes();
					//initiate a Cipher variable for encryption
					Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
					cipher.init(Cipher.ENCRYPT_MODE, key1, ivSpec);
					// Encryption in action
					byte[] encrypted= cipher.doFinal(input);
					//Display the base64 encoded result in the text bar named text_1
					String x = new Base64().encodeToString(encrypted);
					text_1.setText(x);

					}
					catch(Exception ex) {
					ex.printStackTrace();
					return;
					}
			}
		});
		btnEncryptText.setBounds(131, 203, 85, 35);
		btnEncryptText.setText("Encrypt");
		
	//This is the button for encrypting the text within the SWT application
		Button btnDecryptText = new Button(composite, SWT.NONE);
		btnDecryptText.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnDecryptText.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//Read back the encrypted text from the text bar named text_1
					String x = text_1.getText();
					
					//Decode the text before decryption
					byte[] encrypted = new Base64().decode(x);
					
					//initiate a Cipher variable for decryption
					Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
					cipher.init(Cipher.DECRYPT_MODE, key1, ivSpec);
					
					// Decryption in action
					byte[] decrypted= cipher.doFinal(encrypted);
					
					//Display the result in the text bar named text_2
					text_2.setText(new String(decrypted));
					}
					catch (Exception ex){
					 ex.printStackTrace();
					return;
					}
			}
		});
		btnDecryptText.setBounds(260, 203, 92, 35);
		btnDecryptText.setText("Decrypt");
		
		Button btnClear = new Button(composite, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("");
				text_1.setText("");
				text_2.setText("");
			}
		});
		btnClear.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnClear.setBounds(427, 203, 85, 35);
		btnClear.setText("Clear");
		
		TabItem tbtmFile = new TabItem(tabFolder, SWT.NONE);
		tbtmFile.setText("File");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmFile.setControl(composite_1);
		
	//------------------------------------------------------ File Encryption and Decryption --------------------------------------------------------	
		
		//button used to allow the user to browse for a specific file
		Button btnSelectAFile = new Button(composite_1, SWT.NONE);
		btnSelectAFile.addSelectionListener(new SelectionAdapter() {
			@Override
		public void widgetSelected(SelectionEvent e) {
				try {
					final Shell shell = new Shell();
					FileDialog Fdlg = new FileDialog(shell, SWT.OPEN);
					
					String filePath = Fdlg.open();
					if (filePath != null) {
					text_3.setText(filePath);
					}
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		btnSelectAFile.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		btnSelectAFile.setBounds(46, 29, 109, 34);
		btnSelectAFile.setText("Select a file");
		
		text_3 = new Text(composite_1, SWT.BORDER);
		text_3.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_3.setBounds(174, 29, 226, 34);
		
		//button for encrypting the text file and displaying the path to that file
		Button btnEncryptFile = new Button(composite_1, SWT.NONE);
		btnEncryptFile.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnEncryptFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					 encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
					 encrypt.init(Cipher.ENCRYPT_MODE, key1, ivSpec);
					 encrypt(new FileInputStream(text_3.getText()),
					 new FileOutputStream("M:\\New Folder\\Encrypted.txt"));
					 text_4.setText("M:\\New Folder\\Encrypted.txt");
					} catch (Exception e1) {
					e1.printStackTrace();
					}	
			}
		});
		btnEncryptFile.setBounds(46, 96, 109, 34);
		btnEncryptFile.setText("Encrypt");
		
		//button for decrypting the text file and displaying the path to that file
		Button btnDecryptFile = new Button(composite_1, SWT.NONE);
		btnDecryptFile.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnDecryptFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
					decrypt.init(Cipher.DECRYPT_MODE, key1, ivSpec);
					decrypt(new FileInputStream(text_4.getText()),
					new FileOutputStream("M:\\New Folder\\Decrypted.txt"));
					text_5.setText("M:\\New Folder\\Decrypted.txt");
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		btnDecryptFile.setBounds(46, 166, 109, 36);
		btnDecryptFile.setText("Decrypt");
		
		text_4 = new Text(composite_1, SWT.BORDER);
		text_4.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_4.setBounds(174, 96, 226, 36);
		
		text_5 = new Text(composite_1, SWT.BORDER);
		text_5.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_5.setBounds(174, 166, 226, 36);
		
		//this button allows the user to view the files after encryption and decryption
		Button btnOpenFileExplorer = new Button(composite_1, SWT.NONE);
		btnOpenFileExplorer.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnOpenFileExplorer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
					try {
						Desktop.getDesktop().open(new File("M:\\new folder"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
				}
		});
		btnOpenFileExplorer.setBounds(181, 217, 221, 34);
		btnOpenFileExplorer.setText("Open File Explorer to view files");
		
		Button btnClear_1 = new Button(composite_1, SWT.NONE);
		btnClear_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_3.setText("");
				text_4.setText("");
				text_5.setText("");
				
				
			}
		});
		btnClear_1.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnClear_1.setBounds(448, 217, 94, 34);
		btnClear_1.setText("Clear");
		
		TabItem tbtmImage = new TabItem(tabFolder, SWT.NONE);
		tbtmImage.setText("Image");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmImage.setControl(composite_2);
		
	//---------------------------------------------------------------- Image Encryption and Decryption-----------------------------------------------------
		//button used to browse for image and display pathway in textbox
		Button btnBrowseForImage = new Button(composite_2, SWT.NONE);
		btnBrowseForImage.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnBrowseForImage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
					try {

						final Shell shell = new Shell();
						FileDialog fdlg = new FileDialog(shell, SWT.OPEN);
						String filePath = fdlg.open();
						if (filePath != null) {
						text_6.setText(filePath);
						theFile = filePath;
						}
						} catch (Exception e1) {
						e1.printStackTrace();
						}
					}
				});
			
		btnBrowseForImage.setBounds(34, 33, 129, 35);
		btnBrowseForImage.setText("Browse For Image");
		
		//button used to encrypt the image and display pathway in textbox
		Button btnEncryptImage = new Button(composite_2, SWT.NONE);
		btnEncryptImage.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnEncryptImage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				File file = new File(theFile);
				try {
					FileInputStream imageInFile = new FileInputStream(file);
                    byte imageData[] = new byte[(int) file.length()];
                    imageInFile.read(imageData);
                    imageInFile.close();
                    
         
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    byte [] encrypted = cipher.doFinal(imageData);
                    
                    FileOutputStream fos = new FileOutputStream ("M://New folder/Encrypted.jpg");
                    fos.write(encrypted);
                    fos.close();        
                    
                    text_7.setText("M:/New folder/Encrypted.jpg");
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
			
		});
		btnEncryptImage.setBounds(46, 90, 117, 35);
		btnEncryptImage.setText("Encrypt Image");
		
		//button used to decrypt the image and display pathway to textbox
		Button btnDecryptImage = new Button(composite_2, SWT.NONE);
		btnDecryptImage.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnDecryptImage.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				File file = new File("M:/New folder/Encrypted.jpg");
				try {
					FileInputStream imageInFile = new FileInputStream(file);
                    byte imageData[] = new byte[(int) file.length()];
                    imageInFile.read(imageData);
                    imageInFile.close();
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    byte [] decrypted = cipher.doFinal(imageData);
                    
                    FileOutputStream fos = new FileOutputStream ("M:\\new folder\\Decrypted.jpg");
                    fos.write(decrypted);
                    fos.close();
                    
                    text_8.setText("M:\\new folder\\Decrypted.jpg");

					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		btnDecryptImage.setBounds(46, 152, 117, 37);
		btnDecryptImage.setText("Decrypt Image");
		
		text_6 = new Text(composite_2, SWT.BORDER);
		text_6.setBounds(177, 33, 199, 35);
		
		text_7 = new Text(composite_2, SWT.BORDER);
		text_7.setBounds(177, 90, 199, 35);
		
		text_8 = new Text(composite_2, SWT.BORDER);
		text_8.setBounds(177, 152, 199, 37);
		
		//button used to browse directory for encrypted and decrypted image
		Button btnOpenFileExplorer_2 = new Button(composite_2, SWT.NONE);
		btnOpenFileExplorer_2.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnOpenFileExplorer_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Desktop.getDesktop().open(new File("M:\\new folder"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOpenFileExplorer_2.setBounds(177, 209, 199, 31);
		btnOpenFileExplorer_2.setText("Open File explorer to view files");
		
		Button btnClear_2 = new Button(composite_2, SWT.NONE);
		btnClear_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_6.setText("");
				text_7.setText("");
				text_8.setText("");
			}
		});
		btnClear_2.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnClear_2.setBounds(428, 209, 107, 31);
		btnClear_2.setText("Clear");
		
		TabItem tbtmFolder = new TabItem(tabFolder, SWT.NONE);
		tbtmFolder.setText("Folder with a password");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmFolder.setControl(composite_3);
		
	//-------------------------------------------------------Folder with Password Encryption and Decryption---------------------------------------	
		
		Button btnBrowseForFolder = new Button(composite_3, SWT.NONE);
		btnBrowseForFolder.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnBrowseForFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					final Shell shell = new Shell();
					DirectoryDialog Ddlg = new DirectoryDialog(shell, SWT.OPEN);
				    Ddlg.setFilterPath("M:\\new folder"); 
					String FilePath = Ddlg.open();
					if (FilePath != null) {
						text_9.setText(FilePath);
							theFile = FilePath;
						}
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		btnBrowseForFolder.setBounds(47, 25, 139, 36);
		btnBrowseForFolder.setText("Browse for Folder");
		
		//This is a button used to encrypt a folder with a password
		Button btnEncryptWith = new Button(composite_3, SWT.NONE);
		btnEncryptWith.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnEncryptWith.addSelectionListener(new SelectionAdapter() {
			@Override
		public void widgetSelected(SelectionEvent e) {
				FileOutputStream fos;
				try {
					String First_password;
					First_password = JOptionPane.showInputDialog("What is your password?");
					First_pass=First_password;
					JOptionPane.showMessageDialog(null, "Your folder will now be zipped and encrypted");
					fos = new FileOutputStream("M:\\new folder\\Zip Folder.zip");
                    final ZipOutputStream zipOut = new ZipOutputStream(fos);
                    
                    final File fileToZip = new File(text_9.getText());
                    zipFile(fileToZip, fileToZip.getName(), zipOut);
                    zipOut.close();
                    fos.close();
    
                    encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
                    encrypt.init(Cipher.ENCRYPT_MODE, key1, ivSpec);    
                    encrypt(new FileInputStream("M:\\new folder\\Zip Folder.zip"), 
                    		new FileOutputStream("M:\\new folder\\Encrypted Folder"));
             
                    text_11.setText("M:\\new folder\\Encrypted Folder");
   					
				} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
		});
		
		btnEncryptWith.setBounds(32, 81, 154, 36);
		btnEncryptWith.setText("Encrypt with password");
		
		//This is the button used to decrypt a folder with the confirmation of a password
		Button btnDecryptWith = new Button(composite_3, SWT.NONE);
		btnDecryptWith.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnDecryptWith.addSelectionListener(new SelectionAdapter() {
			@Override
		public void widgetSelected(SelectionEvent e) {
				try {
					String Second_password;
					Second_password = JOptionPane.showInputDialog("Please confirm your password?");
					if (Second_password.equals(First_pass)) {
						JOptionPane.showMessageDialog(null,  "Success! The folder will now be decrypted");
						
						decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
                        decrypt.init(Cipher.DECRYPT_MODE, key1, ivSpec);
                        decrypt(new FileInputStream(text_11.getText()),
                        		new FileOutputStream("M:\\new folder\\Decrypted Folder.zip"));
	                    
	                    text_12.setText("M:\\new folder\\Decrypted Folder");
	                    unZip();
						
					}	else {
						JOptionPane.showMessageDialog(null,  "Sorry Wrong Password");
						System.exit(0);
					}
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
				
			}
		});
		btnDecryptWith.setBounds(32, 136, 154, 36);
		btnDecryptWith.setText("Decrypt with password");
		
		text_9 = new Text(composite_3, SWT.BORDER);
		text_9.setBounds(203, 25, 163, 32);
		
		text_11 = new Text(composite_3, SWT.BORDER);
		text_11.setBounds(203, 81, 163, 36);
		
		text_12 = new Text(composite_3, SWT.BORDER);
		text_12.setBounds(203, 139, 163, 33);
		
		//button used to open directory of the encrypted and decrypted folders
		Button btnOpenFileExplorer_1 = new Button(composite_3, SWT.NONE);
		btnOpenFileExplorer_1.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnOpenFileExplorer_1.addSelectionListener(new SelectionAdapter() {
			@Override
		public void widgetSelected(SelectionEvent e) {
				try {
					Desktop.getDesktop().open(new File("M:\\new folder"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOpenFileExplorer_1.setBounds(144, 208, 222, 32);
		btnOpenFileExplorer_1.setText("Open File Explorer to view folders");
		
		Button btnClear_3 = new Button(composite_3, SWT.NONE);
		btnClear_3.addSelectionListener(new SelectionAdapter() {
			@Override
		public void widgetSelected(SelectionEvent e) {
				text_9.setText("");
				text_11.setText("");
				text_12.setText("");
			}
		});
		btnClear_3.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		btnClear_3.setBounds(430, 208, 98, 32);
		btnClear_3.setText("Clear");
		
		
		Label lblNewLabel = new Label(shlComputerSecurityTool, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.DRAW_TRANSPARENT));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.ITALIC));
		lblNewLabel.setBounds(10, 337, 572, 28);
		lblNewLabel.setText("For more Information on encryption and decryption please double click on the link below:");
		
		Label lblChooseAMethod = new Label(shlComputerSecurityTool, SWT.NONE);
		lblChooseAMethod.setBackground(SWTResourceManager.getColor(SWT.DRAW_TRANSPARENT));
		lblChooseAMethod.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblChooseAMethod.setBounds(10, 10, 487, 28);
		lblChooseAMethod.setText("Choose a method for encryption and decryption from the options below:");
		
		//this is the link used in the interface to allow the user to view more information in the web browser
		Link link = new Link(shlComputerSecurityTool, SWT.NONE);
		link.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		link.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		link.setText("<a>Encryption and Decryption Link</a>");
		link.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseDoubleClick(MouseEvent e) {
				org.eclipse.swt.program.Program.launch("https://developer.mozilla.org/en-US/docs/Archive/Security/Encryption_and_Decryption");
			}
		});
		link.setBounds(20, 371, 229, 27);
		
		Button btnNewButton = new Button(shlComputerSecurityTool, SWT.NONE);
		btnNewButton.setLocation(0, 0);
		btnNewButton.setSize(644, 420);
		btnNewButton.setGrayed(true);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
		public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage("M:\\eclipse-neon\\SecurityTool\\White-Background-Wallpaper-16577.jpg"));
		

		shlComputerSecurityTool.open();
		shlComputerSecurityTool.layout();
		while (!shlComputerSecurityTool.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
			}
		}
	}

