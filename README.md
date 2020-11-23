# 手打按时

```java
//去除重复字母,且字典序最小
Class Solution{
	public String method(String s){
		Stack<Character> stack = new Stack<>();
		//ASCALL码的范围是256内
		int[] count = new int[256];
        for(int i = 0 ; i < s.length(); i++){
            count[s.charAt(i)] ++ ;
        }
		boolean[] isInStack = new boolean[256];
		
		for(Character c2 :s.toCharArray()){
			//遍历s，每次进去，这个字符的数量减少1
			count[c2] --;
			//如果栈里面已经存在这个字符了，那么就过
			if(isInStack[c2] == true){
				continue;
			}
			while(!stack.isEmpty() && c2 < stack.peek()){
			 //如果栈顶元素已经是s中没有重复的字符了，那么就不能弹出了
			 if(count[stack.peek()] == 0){
				 break;
			 }
			 isInStack[stack.pop()] =  false; 
			}
			stack.push(c2);
			isInStack[c2] = true;
		}
		
		//反转字符串
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.reverse().toString();	
	}	
}
```

