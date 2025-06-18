// Name Surname: Ayse Zülal Simsek
// Student ID : 22050111047
/*
My code manage a music playlist using singly and doubly linked lists.
Users can add, remove, move, and play songs and change the song only for the doublylinklist.
Singly linked list allows one way while doubly linked list supports both forward and backward movement therefore doubly. has prev song.
*/

// SingleSong class for single linked list and it has private variables
class SingleSong {
    private String title;
    private String artist;
    private int duration;
    private SingleSong next;

    
    public SingleSong(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.next = null;  // next is null at the first
    }

    // my getter and setter methods for private variables
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public SingleSong getNext() {
        return next;
    }

    public void setNext(SingleSong next) {
        this.next = next;
    }
}

// DoubleSong class for doubly linked list and it has private variables
class DoubleSong {
    private String title;
    private String artist;
    private int duration;
    private DoubleSong next;
    private DoubleSong prev;

    // this class has next and prev* and it has two ways 
    public DoubleSong(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.next = null;  // next is null in the first
        this.prev = null;  // prev is null in the first
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public DoubleSong getNext() {
        return next;
    }

    public void setNext(DoubleSong next) {
        this.next = next;
    }

    public DoubleSong getPrev() {
        return prev;
    }

    public void setPrev(DoubleSong prev) {
        this.prev = prev;
    }
}


class SinglyLinkedList {
    private SingleSong head;

    
    public SinglyLinkedList() {
        this.head = null;  // head is null at first
    }

    // we add song with this method and if list is empty we add to head song if not we add soong end of list
    public void addSong(String title, String artist, int duration) {
        SingleSong newSong = new SingleSong(title, artist, duration);
        if (head == null) {
            head = newSong;  
        } else {
            SingleSong current = head;
            while (current.getNext() != null) {
                current = current.getNext();  
            }
            current.setNext(newSong);  
        }
    }

    // Method to remove song from list
    public void removeSong(String title) {
        if (head == null) {
            System.out.println(title + " is not found.");  
            return;
        }
         // if song is head 
        if (title.equals(head.getTitle())) {
            head = head.getNext(); 
            System.out.println(title + " is deleted.");
            return;
        }

        SingleSong current = head;
        SingleSong prev = head;
        // find the song to remove
        while (current != null && !title.equals(current.getTitle())) {
            prev = current;
            current = current.getNext();  
        }

        if (current == null) {
            System.out.println(title + " is not found.");  // if doesnot found
        } else {
            prev.setNext(current.getNext());  // remove song
            System.out.println(title + " is deleted.");
        }
    }

    // Method to display playlist
    public void displayPlaylist() {
        SingleSong current = head;
        if (current == null) {
            System.out.println("The list is empty.");  // if list is empty
            return;
        }
        while (current != null) {
            System.out.println(current.getTitle() + ", " + current.getArtist() + ", " + current.getDuration());
            current = current.getNext();  // we writed all songs 
        }
    }

    // Method to search for a song
    public void searchSong(String title) {
        SingleSong current = head;
        while (current != null) {
            if (title.equals(current.getTitle())) {
                System.out.println("DETAILS OF SONG: ");
                System.out.println(current.getTitle() + " " + current.getArtist() + " " + current.getDuration());
                return;  // song is founded
            }
            current = current.getNext();
        }
        System.out.println("The song is not found.");  // song is not founded
    }
}


class DoublyLinkedList {
    private DoubleSong head;
    private DoubleSong tail;
    private DoubleSong current; // this is song which is now playing

    
    public DoublyLinkedList() {
        this.head = null;  
        this.tail = null;  
        this.current = null;  
    }

    // Method to add song to list
    public void addSong(String title, String artist, int duration) {
        DoubleSong newSong = new DoubleSong(title, artist, duration);
        if (head == null && tail == null) {   // if list is empty so new song is head and tail at the same time
            head = newSong;  
            tail = newSong;  
        } else {  // add new song to end
            tail.setNext(newSong); 
            newSong.setPrev(tail);  
            tail = newSong;  
        }
    }

    // this method can check find the song if conditions is valid operations start
    public void removeSong(String title) {
        if (head == null) {
            System.out.println(title + " is not found.");  // list is empty
            return;
        }

        DoubleSong current = head;
        while (current != null && !title.equals(current.getTitle())) {
            current = current.getNext();  // find this song to remove
        }

        if (current == null) {
            System.out.println(title + " is not found.");  // song is not founded
            return;
        }

        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());  // remove song
        } else {
            head = current.getNext();  // if song is head 
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());  // remove song
        } else {
            tail = current.getPrev();  // if song is tail remove tail
        }

        System.out.println(title + " is deleted.");
    }

    // Method to display playlist
    public void displayPlaylist() {
        DoubleSong current = head;
        if (current == null) {
            System.out.println("The list is empty.");  // if list is empty
            return;
        }
        while (current != null) {
            System.out.println(current.getTitle() + ", " + current.getArtist() + ", " + current.getDuration());
            current = current.getNext();  
        }
    }

    // Method for the change playing song to next
    public void playNext() {
        if (current == null) {
            if (head == null) {
                System.out.println("Playlist is empty. Add songs first.");  // playlist is empty
                return;
            }
            current = head;  // if no current song, start from head
        }
        else if (current.getNext() != null) {
            current = current.getNext();  // skip to next song
        } else {
            System.out.println("You have reached the end of the playlist.");  // end of list
            return;
        }
        System.out.println("Currently playing: " + current.getTitle());  
    }

    
    public void playPrevious() {
        if (current == null) {
            if (tail == null) {
                System.out.println("Playlist is empty. Add songs first.");  // playlist is empty
                return;
            }
            current = tail;  // if no current song we start from tail
        } else if (current.getPrev() != null) {
            current = current.getPrev();  // skip to previous song
        } else {
            System.out.println("You are at the beginning of the playlist.");  // start of list
            return;
        }
        System.out.println("Currently playing: " + current.getTitle());  // wr,ting current song
    }

    // Method to check if list is empty
    public boolean isEmpty() {
        return head == null;  // if head is null so list is empty
    }

    // we take the length of list from this method
    public int getLength() {
        int count = 0;
        DoubleSong current = head;
        while (current != null) {
            count++;  
            current = current.getNext();
        }
        return count;  
    }

    // if song is founded return this song if not method return null 
    public DoubleSong searchSong(String title) {
        DoubleSong current = head;
        while (current != null) {
            if (title.equals(current.getTitle())) {
                return current;  
            }
            current = current.getNext();
        }
        return null;  
    }

    // Method to move song to new position
    public void moveSong(String title, int position) {
        if (position < 1 || position > getLength()) { // if position is invalid write error message
            System.out.println("Invalid position.");  
            return;
        }

        DoubleSong temp = searchSong(title);
        if (temp == null) {
            System.out.println("Song not found.");  // if song is not found
            return;
        }

        // Remove song from current position
        if (temp.getPrev() != null) {
            temp.getPrev().setNext(temp.getNext());  
        } else {
            head = temp.getNext();  // if song is head it delete head
        }

        if (temp.getNext() != null) {
            temp.getNext().setPrev(temp.getPrev());  
        } else {
            tail = temp.getPrev();  // if song is tail
        }

        // Insert song at new position
        if (position == 1) {
            temp.setNext(head);  //if user want to add head
            temp.setPrev(null);
            if (head != null) {
                head.setPrev(temp);
            }
            head = temp;
        } else {
            DoubleSong current = head;
            for (int i = 1; i < position - 1; i++) {
                
                current = current.getNext();  
            }
            temp.setNext(current.getNext());  // add song
            temp.setPrev(current);
            if (current.getNext() != null) {
                current.getNext().setPrev(temp);
            }
            current.setNext(temp);
        }

        System.out.println("Song moved to position " + position);  // print success message
    }
}