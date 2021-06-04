package mod;

public class Player {
  //this class creates a player with the position of the player
  private int _row;
  
  private int _col;
  
  private boolean _isAlive;
  
  private boolean _sword;
  
  public int getRow() {
    return this._row;
  }
  
  public int getCol() {
    return this._col;
  }
  
  public void setPos(int r, int c) {
    this._row = r;
    this._col = c;
  }
  
  public Player(int r, int c) {
    this._row = r;
    this._col = c;
    this._isAlive = true;
    this._sword = false;
  }
  //This method checks if the player is alive
  public boolean isAlive() {
    return this._isAlive;
  }
  //This method kills
  public void kill() {
    this._isAlive = false;
  }
  //This method checks if the player has the sword
  public boolean hasSword() {
    return this._sword;
  }
  //This method gives the sword to the player
  public void giveSword() {
    this._sword = true;
  }
}
