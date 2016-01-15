SRC_DIR=src/com/example
OUT_DIR=out/production/GameOfLife
PACKAGE_DIR=com/example

mkdir -p $OUT_DIR \
&& \
javac $SRC_DIR/rules/*.java -d $OUT_DIR \
&& \
javac -cp $OUT_DIR $SRC_DIR/*.java -d $OUT_DIR \
&& \
java -cp $OUT_DIR com.example.Main
