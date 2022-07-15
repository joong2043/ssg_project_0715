public class Rq {
    private String path;
    private String[] queryStrBits;

    public Rq(String cmd){
        String[] cmdBits = cmd.split("\\?",2);

        this.path=cmdBits[0];

        if(cmdBits.length==2){
            this.queryStrBits = cmdBits[1].split("&");
        }
    }


    public String getPath(){
        return path;
    }


    public int getIntParam(String paramName, int defaultvalue) {
        if(paramName==null){
            return defaultvalue;
        }
        else{
            String[] params = queryStrBits[0].split("=");
            int paramId = (int) Integer.parseInt(params[1]);
            return paramId;
        }
    }
}
