/***************************************************************************************
* Code from:
*
* Title: 101 The Blocks Problem
* Author: Diusrex
* Date: 15 - Dec - 2017
* Code version: Unknown
* Availability: https://goo.gl/iJ7eA6
* 
* Modified by anietog1
***************************************************************************************/
#include <iostream>
#include <string>

using namespace std;

#define MAXN 30

struct node{//asi es mas facil, en vez de con listas
  int prev, next;
  bool original;
  node(): prev(-1), next(-1), original(true)
  {}
};

//GLOBAL VARS
node nodes[MAXN];

bool valid(int a, int b){//O(n) worst case
  //Indicates if a and b are not in the same stack
  if(a == b)
    return false;

  int c = a;
  while(c != -1){
    c = nodes[c].next;
    if(c == b)
      return false;
  }

  c = b;
  while(c != -1){
    c = nodes[c].next;
    if(c == a)
      return false;
  }

  return true;
}

void print(int n){
  for(int i=0; i < n; ++i){
    cout << i << ":";
    if(nodes[i].original){
      int curr = i;

      while(curr != -1){
	cout << " " << curr;
       	curr = nodes[curr].next;
      }
    }
    
    cout << endl;
  }
}

int main(){
  int n, a, b, curr, next;
  string main, second;//idk what happens with char[]... if used, then TLE

  cin >> n >> main;  
  while(main != "quit"){
    cin >> a >> second >> b;

    if(!valid(a, b)){//after valid, both b and a are their real stack
      cin >> main;
      continue;
    }
    
    if(second == "onto"){//in case onto, then clean the b
      //the clean is made by returning each next node to its starting state
      curr = nodes[b].next;
      while(curr != -1){
	nodes[curr].prev = -1;
	next = nodes[curr].next;
	nodes[curr].next = -1;
	nodes[curr].original = true;
	curr = next;
      }
    }else{
      while(nodes[b].next != -1){//else, its over, then go til last item of b, to append :o
	b = nodes[b].next;
      }
    }

    if(main == "move"){//if move, then have to clean a
      //the clean is made the same as the clean of b in 'onto'
      curr = nodes[a].next;
      while(curr != -1){
	nodes[curr].prev = -1;
	next = nodes[curr].next;
	nodes[curr].next = -1;
	nodes[curr].original = true;
	curr = next;
      }
      
      nodes[a].next = -1;//after all, reset a, too
    }

    if(nodes[a].prev != -1)//remove a as the next of its previous...
      nodes[nodes[a].prev].next = -1;
    
    nodes[a].prev = b;
    nodes[b].next = a;
    nodes[a].original = false;

    cin >> main;
  }

  print(n);
}
