public class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return superUseBase() + ", blade sharpened first";
    }

    protected String superUseBase() {
        return "Using the tool in the garden";
    }
}
