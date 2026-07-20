#!/bin/bash

echo "Enter two numbers:"

read a b
sum=$((a+b))
echo "Sum: $sum"

if [ $a -gt $b ]
then
echo "$a is greater than $b"
elif [ $a -eq $b ]
then 
echo "$a is equal than $b"
else 
echo "$a is less than $b"
fi

str="hello"
echo ${#str}   # length
echo ${str:1:3} # substring


for j in 1 2 3 4 5 
do
echo $j
done

i=1
while [ $i -le 5 ]
do
    echo $i
    i=$((i+1))
done
