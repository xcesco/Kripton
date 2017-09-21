package sqlite.feature.schema.version2;

import java.lang.String;

/**
 * <p>
 * Entity <code>Seminar2Student</code> is associated to table <code>seminar_2_student</code>
 * This class represents table associated to entity.
 * </p>
 *  @see Seminar2Student
 */
public class Seminar2StudentTable {
  /**
   * Costant represents typeName of table seminar_2_student
   */
  public static final String TABLE_NAME = "seminar_2_student";

  /**
   * <p>
   * DDL to create table seminar_2_student
   * </p>
   *
   * <pre>CREATE TABLE seminar_2_student (id INTEGER PRIMARY KEY AUTOINCREMENT, student_id INTEGER, seminar_id INTEGER, FOREIGN KEY(student_id) REFERENCES student(id), FOREIGN KEY(seminar_id) REFERENCES seminar(id));</pre>
   */
  public static final String CREATE_TABLE_SQL = "CREATE TABLE seminar_2_student (id INTEGER PRIMARY KEY AUTOINCREMENT, student_id INTEGER, seminar_id INTEGER, FOREIGN KEY(student_id) REFERENCES student(id), FOREIGN KEY(seminar_id) REFERENCES seminar(id));";

  /**
   * <p>
   * DDL to drop table seminar_2_student
   * </p>
   *
   * <pre>DROP TABLE IF EXISTS seminar_2_student;</pre>
   */
  public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS seminar_2_student;";

  /**
   * Entity's property <code>id</code> is associated to table column <code>id</code>. This costant represents column name.
   *
   *  @see Seminar2Student#id
   */
  public static final String COLUMN_ID = "id";

  /**
   * Entity's property <code>studentId</code> is associated to table column <code>student_id</code>. This costant represents column name.
   *
   *  @see Seminar2Student#studentId
   */
  public static final String COLUMN_STUDENT_ID = "student_id";

  /**
   * Entity's property <code>seminarId</code> is associated to table column <code>seminar_id</code>. This costant represents column name.
   *
   *  @see Seminar2Student#seminarId
   */
  public static final String COLUMN_SEMINAR_ID = "seminar_id";
}
