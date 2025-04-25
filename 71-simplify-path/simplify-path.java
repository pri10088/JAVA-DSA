class Solution {
    public String simplifyPath(String path) {
        Stack<String> St = new Stack<>();
        String[] parts = path.split("/");

        for(String part : parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!St.isEmpty()){
                    St.pop();
                }
            }else{
                St.push(part);
            }
        }
        return "/" + String.join("/" , St);
        
    }
}