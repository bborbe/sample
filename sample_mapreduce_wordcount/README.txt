create keyspace wordcount;

use wordcount;

create column family input_words with
  comparator = UTF8Type and
  key_validation_class = UTF8Type and
  default_validation_class = UTF8Type;

create column family output_words with
  comparator = UTF8Type and
  key_validation_class = UTF8Type and
  default_validation_class = UTF8Type;


truncate input_words;
truncate output_words;
SET input_words['keyA']['text'] = 'foo bar';
SET input_words['keyB']['text'] = 'foo bar bla bla';
SET input_words['keyC']['text'] = 'bla bla';