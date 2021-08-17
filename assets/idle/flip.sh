convert -flop 0.png left0.png
for i in {1..9}
do
	convert -flop ${i}.png left${i}.png
done

