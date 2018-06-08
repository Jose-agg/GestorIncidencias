#!/bin/bash
ls -l ; 
echo "" ; 
rm -rf inci_e2a ; 
ls -l ;  
echo "" ; 
git clone --recurse-submodules https://github.com/Arquisoft/inci_e2a.git ; 
ls -l ; 
echo "" ; 
cd inci_e2a ; 
ls -l ; 
echo "" ;