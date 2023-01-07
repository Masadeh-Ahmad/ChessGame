package game;

public class MoveParameter {
    private Integer sourceColumn;
    private Integer sourceRow;
    private Integer destinationColumn;
    private Integer destinationRow;

    public int getSourceColumn() {
        return sourceColumn;
    }

    public void setSourceColumn(int sourceColumn) {
        this.sourceColumn = sourceColumn;
    }

    public int getSourceRow() {
        return sourceRow;
    }

    public void setSourceRow(int sourceRow) {
        this.sourceRow = sourceRow;
    }

    public int getDestinationColumn() {
        return destinationColumn;
    }

    public void setDestinationColumn(int destinationColumn) {
        this.destinationColumn = destinationColumn;
    }

    public int getDestinationRow() {
        return destinationRow;
    }

    public void setDestinationRow(int destinationRow) {
        this.destinationRow = destinationRow;
    }
    public boolean isValid(){
        return (sourceRow != null && sourceColumn != null && destinationRow != null && destinationColumn != null);
    }
}
