package mod;

public class Player {
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
  
  public boolean isAlive() {
    return this._isAlive;
  }
  
  public void kill() {
    this._isAlive = false;
  }
  
  public boolean hasSword() {
    return this._sword;
  }
  
  public void giveSword() {
    this._sword = true;
  }
}
