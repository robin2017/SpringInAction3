DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES
  ('140754', 'robin', 'male'),
  ('140753', 'peter', 'female');
COMMIT;