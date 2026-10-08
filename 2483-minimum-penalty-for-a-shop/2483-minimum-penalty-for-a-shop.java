class Solution {
    public int bestClosingTime(String customers) {
       int penalty=0;
       for(int i=0;i<customers.length();i++){
        if(customers.charAt(i)=='Y'){
            penalty++;
        }
       }
       int minpenalty=penalty;
       int answer=0;
       for(int i=0;i<customers.length();i++){
        if(customers.charAt(i)=='Y'){
            penalty--;
        }
        else{
            penalty++;
        }
        if(penalty<minpenalty){
            minpenalty=penalty;
            answer=i+1;
        }
       }
       return answer;
       }
    }