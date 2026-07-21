import java.util.HashMap;

public class Test{
    public class urlManager {
        // 使用 HashMap 保存 url 是否为白名单
        HashMap<String, Boolean> map;
        int maxSize;
        int LIMIT_URL_LENGTH = 100;
        public urlManager(int size){
            this.maxSize = size;
            map = new HashMap<>();
        }

        public Boolean get(String url){
            if(url.length() > LIMIT_URL_LENGTH){
                return null;
            }
            url = ignoreFormat(url);
            // 同时实现最长匹配原则：www.xxx.com/web 在 map 中不存在时，返回 www.xxx.com 的内容
            // 如果 www.xxx.com 是黑名单，则 www.xxx.com/web 也是黑名单 ==> 查询的时候按照规则查，先查 www.xxx.com 后查 www.xxx.com/web 
            String[] parts = url.split("/");
            StringBuilder sb = new StringBuilder();
            sb.append(parts[0]);
            
            String match = null;
            for(int i=1; i<parts.length; i++){
                String preUrl = sb.toString();
                if(map.containsKey(preUrl)){
                    match = preUrl;
                    if(map.get(preUrl) == false){
                        return false;
                    }
                }
                sb.append(parts[i]);
            }

            // 如果不存在 url 的 key，则返回最长匹配的 key 的 value
            boolean flag = map.containsKey(url);
            if(!flag){
                return map.get(match);
            }
            
            return map.get(url);
        }

        public Boolean remove(String url){
            if(url.length() > LIMIT_URL_LENGTH){
                return null;
            }
            url = ignoreFormat(url);
            return map.remove(url);
        }

        // 增，删
        public Boolean put(String url, boolean isBlank){
            if(url.length() > LIMIT_URL_LENGTH){
                return null;
            }
            url = ignoreFormat(url);
            if(!map.containsKey(url) && map.size() == maxSize){
                return false;
            }
            return map.put(url, isBlank);
            
        }

        // https;// http:// 和不带该前缀的等价
        private String ignoreFormat(String url){
            char[] chrs = url.toCharArray();
            if(url.startsWith("https://")){
                return new String(chrs, 8, url.length() - 8);
            }else if(url.startsWith("http://")){
                return new String(chrs, 7, url.length() - 7);
            }
            return url;
        }
        
    }
    public static void main(String[] args){
    }
} 