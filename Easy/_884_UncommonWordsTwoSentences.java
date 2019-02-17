  
  public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap();
        if (A.length() > 1) {
            for (String str : A.split(" ")) {
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
        if (B.length() > 1) {
            for (String str : B.split(" ")) {
                if(map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
        }
        
        List<String> list = map.entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        return list.toArray(new String[list.size()]);
    }
