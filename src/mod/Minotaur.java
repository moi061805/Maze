package mod;

public class Minotaur {
  private int _row;
  
  private int _col;
  
  private boolean _isAlive;
  
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
  
  public Minotaur(int r, int c) {
    this._row = r;
    this._col = c;
    this._isAlive = true;
  }
  
  public boolean isAlive() {
    return this._isAlive;
  }
}
