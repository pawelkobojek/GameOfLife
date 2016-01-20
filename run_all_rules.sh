SRC_DIR=src/com/example
OUT_DIR=out/production/GameOfLife
RESULT_DIR=out/production/results
PACKAGE_DIR=com/example
RULES_DIR=src/com/example/rules
GAME_SIZE=10
RUNS_PER_PROB=100
MAX_STEPS=100

if mkdir -p $OUT_DIR \
&& \
mkdir -p $RESULT_DIR \
&& \
javac $SRC_DIR/rules/*.java -d $OUT_DIR \
&& \
javac -cp $OUT_DIR $SRC_DIR/*.java -d $OUT_DIR; then
	RULES_DIR_LEN=$[${#RULES_DIR}+2]
	for f in ${RULES_DIR}/*.java; do
		RULE_NAME=$(echo "${f%.*}" | cut -c ${RULES_DIR_LEN}-)
		if [ "${RULE_NAME}" != "LifeRule" ]; then
			#echo "${RULE_NAME}"
			java -cp $OUT_DIR com.example.Main "${GAME_SIZE}" "${RUNS_PER_PROB}" "${MAX_STEPS}" "${RULE_NAME}" | ./plot.py "${RULE_NAME}" "${RESULT_DIR}" &
		fi
	done
fi
