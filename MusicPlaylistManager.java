package music.playlist.manager;

class SongList {
    String title;  // Title of the song
    SongList next;  // Pointer to the next song in the playlist
    SongList prev;  // Pointer to the previous song in the playlist

    // Constructor for creating a new song node
    public SongList(String title) {
        this.title = title;
        this.next = null;
        this.prev = null;
    }
}

class MusicPlaylistManager {
    private SongList head;  // Points to the first song in the playlist (head of the list)
    private SongList current;  // Points to the currently playing song

    // Constructor to initialize the playlist as empty
    public MusicPlaylistManager() {
        this.head = null;
        this.current = null;
    }
    
    // Adds a new song to the playlist
    public void addSong(String title) {
        SongList newSong = new SongList(title);  // Create a new song node
        
        if (head == null) {  // If the playlist is empty
            head = newSong;  // Set the head to the new song
            head.next = head;  // The new song points to itself as next (circular)
            head.prev = head;  // The new song points to itself as prev (circular)
        } 
        else {  // If the playlist already contains songs
            SongList tail = head.prev;  // Get the last song in the playlist (tail)
            tail.next = newSong;  // Tail's next points to the new song
            newSong.prev = tail;  // New song's prev points to the tail
            newSong.next = head;  // New song's next points to the head (circular)
            head.prev = newSong;  // Head's prev points to the new song (circular)
        }
        
        current = newSong;  // Set the newly added song as the current song
        System.out.println("New Song Added: " + title);  // Print confirmation message
    }
    
    // Removes a song from the playlist
    public void removeSong(String title) {
        if (head == null) {  // If the playlist is empty
            System.out.println("Playlist is Empty");
            return;
        }
        
        SongList temp = head;  // Start traversing from the head
        
        while (true) {
            if (temp.title.equals(title)) {  // If the song is found
                if (temp.next == temp) {  // If there's only one song in the playlist
                    head = null;  // Set head to null (empty playlist)
                    current = null;  // Set current to null (no song is playing)
                } 
                else {  // If there are multiple songs in the playlist
                    temp.prev.next = temp.next;  // Adjust the previous song's next pointer
                    temp.next.prev = temp.prev;  // Adjust the next song's prev pointer
                    
                    if (temp == head) {  // If the song to be removed is the head
                        head = temp.next;  // Move head to the next song
                    }
                    
                    if (temp == current) {  // If the song to be removed is the current song
                        current = temp.next;  // Move current to the next song
                    }
                }
                
                System.out.println("A song was removed: " + title);  // Print confirmation message
                return;
            }
            
            temp = temp.next;  // Move to the next song in the playlist
            
            if (temp == head) {  // If we've come full circle (back to the head)
                break;  // Exit the loop if the song wasn't found
            }
        }
        
        System.out.println("Song " + title + " is not found");  // Print if the song is not found
    }
    
    // Moves to the next song in the playlist
    public void nextSong() {
        if (current != null) {  // If the playlist is not empty
            current = current.next;  // Move current to the next song
            System.out.println("Now playing: " + current.title);  // Print the current song
        } 
        else {
            System.out.println("Playlist is Empty");  // Print if the playlist is empty
        }
    }
    
    // Moves to the previous song in the playlist
    public void previousSong() {
        if (current != null) {  // If the playlist is not empty
            current = current.prev;  // Move current to the previous song
            System.out.println("Now playing: " + current.title);  // Print the current song
        } 
        else {
            System.out.println("Playlist is Empty");  // Print if the playlist is empty
        }
    }
    
    // Displays the entire playlist
    public void displayPlaylist() {
        if (head == null) {  // If the playlist is empty
            System.out.println("Playlist is Empty");
            return;
        }
        
        System.out.println("Playlist:");  // Print the header for the playlist
        SongList temp = head;  // Start from the head
        
        do {
            String currentMarker;  // String to mark the current song
            if (temp == current) {  // If this song is the current song
                currentMarker = " (current)";
            } 
            else {
                currentMarker = "";  // No marker for other songs
            }
            
            System.out.println(temp.title + currentMarker);  // Print song title with the marker
            temp = temp.next;  // Move to the next song
        } 
        while (temp != head);  // Loop until we reach the head again (circular)
    }
    
    // Main method to demonstrate the playlist functionality
    public static void main(String[] args) {
        MusicPlaylistManager musicList = new MusicPlaylistManager();  // Create a new playlist manager
        musicList.addSong("River Flows In You - Yiruma");  // Add a song
        musicList.addSong("Sana - Maki");  // Add another song
        musicList.addSong("Sila - SUD");  // Add another song
        musicList.addSong("APT - Bruno Mars & Rose");  // Add another song
        musicList.displayPlaylist();  // Display the playlist
        
        musicList.nextSong();  // Move to the next song
        musicList.nextSong();  // Move to the next song
        musicList.previousSong();  // Move to the previous song
        
        musicList.removeSong("Sila - SUD");  // Remove a song from the playlist
        musicList.displayPlaylist();  // Display the playlist after removal
        
        musicList.nextSong();  // Move to the next song
        musicList.previousSong();  // Move to the previous song
    }
}
