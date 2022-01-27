public static class Pair implements Comparable<Pair>{
        int phy;
        int chem;
        int maths;
        Pair(int phy, int chem, int maths){
            this.phy = phy;
            this.chem = chem;
            this.maths = maths;
        }
        public int compareTo(Pair other){
            if(this.phy!=other.phy){
                return this.phy-other.phy;
            }else if(this.chem != other.chem){
                return -(this.chem - other.chem);
            }else{
                return this.maths-other.maths;
            }
        }
    }
