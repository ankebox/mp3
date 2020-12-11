 import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    public void listAllFiles(){
        int position = 0;
        
        while (position < files.size()) {
            String filename = files.get(position);
            position++;
            System.out.println(position + filename);
            
        
        }
    }
    
    public void listMatching(String searchString) {
        boolean cancionEncontrada = false;
        for (String filename : files) {
            if (filename.contains(searchString)) {
                System.out.println(filename);
                cancionEncontrada = true;
            
            }
        }
        
        if (cancionEncontrada == false) {
            System.out.println("Error de busqueda ----->" + searchString + ": texto no encontrado");
        }
    }
    
    public void playSampleArtist(String searchString) {
        for (String filename : files) {
            if ( filename.contains(searchString)){
                player. playSample(filename);
            }
        }
    }
    
    public void deleteSongsWithText(String textoAEliminar){
        for (String filename : files) {
            if(filename.contains(textoAEliminar)){
                files.remove(filename);
                
            }
        }
    }
       
    public int findFirst(String searchString) {
        int contador = 0 ;
        boolean searching = true;
        String contenedor = "";
        int aDevolver = -1;
        while (contador < files.size() && searching == true){
            contenedor = files.get(contador);
            if (contenedor.contains(searchString)){
                
                searching = false;
                aDevolver = contador;
            }
            contador = contador + 1;
        }
        
        return aDevolver;
    }
}
