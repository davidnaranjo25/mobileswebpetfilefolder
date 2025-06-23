package com.example.fitpet;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter<UserEntity> __updateAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfAprobarVeterinario;

  private final SharedSQLiteStatement __preparedStmtOfEliminarUsuarioPorId;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `users` (`id`,`nombre`,`correo`,`password`,`telefono`,`pais`,`ciudad`,`rol`,`aprobado`,`direccionLocal`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final UserEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.nombre == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.nombre);
        }
        if (entity.correo == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.correo);
        }
        if (entity.password == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.password);
        }
        if (entity.telefono == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.telefono);
        }
        if (entity.pais == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.pais);
        }
        if (entity.ciudad == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.ciudad);
        }
        if (entity.rol == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.rol);
        }
        final int _tmp = entity.aprobado ? 1 : 0;
        statement.bindLong(9, _tmp);
        if (entity.direccionLocal == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.direccionLocal);
        }
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`nombre` = ?,`correo` = ?,`password` = ?,`telefono` = ?,`pais` = ?,`ciudad` = ?,`rol` = ?,`aprobado` = ?,`direccionLocal` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final UserEntity entity) {
        statement.bindLong(1, entity.id);
        if (entity.nombre == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.nombre);
        }
        if (entity.correo == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.correo);
        }
        if (entity.password == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.password);
        }
        if (entity.telefono == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.telefono);
        }
        if (entity.pais == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.pais);
        }
        if (entity.ciudad == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.ciudad);
        }
        if (entity.rol == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.rol);
        }
        final int _tmp = entity.aprobado ? 1 : 0;
        statement.bindLong(9, _tmp);
        if (entity.direccionLocal == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.direccionLocal);
        }
        statement.bindLong(11, entity.id);
      }
    };
    this.__preparedStmtOfAprobarVeterinario = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET aprobado = 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfEliminarUsuarioPorId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM users WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertarUsuario(final UserEntity usuario) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserEntity.insert(usuario);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUser(final UserEntity usuario) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUserEntity.handle(usuario);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void aprobarVeterinario(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfAprobarVeterinario.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfAprobarVeterinario.release(_stmt);
    }
  }

  @Override
  public void eliminarUsuarioPorId(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfEliminarUsuarioPorId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfEliminarUsuarioPorId.release(_stmt);
    }
  }

  @Override
  public UserEntity buscarUsuarioPorCorreo(final String correo) {
    final String _sql = "SELECT * FROM users WHERE correo = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (correo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, correo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
      final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfAprobado = CursorUtil.getColumnIndexOrThrow(_cursor, "aprobado");
      final int _cursorIndexOfDireccionLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "direccionLocal");
      final UserEntity _result;
      if (_cursor.moveToFirst()) {
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpCorreo;
        if (_cursor.isNull(_cursorIndexOfCorreo)) {
          _tmpCorreo = null;
        } else {
          _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        final String _tmpPais;
        if (_cursor.isNull(_cursorIndexOfPais)) {
          _tmpPais = null;
        } else {
          _tmpPais = _cursor.getString(_cursorIndexOfPais);
        }
        final String _tmpCiudad;
        if (_cursor.isNull(_cursorIndexOfCiudad)) {
          _tmpCiudad = null;
        } else {
          _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
        }
        final String _tmpRol;
        if (_cursor.isNull(_cursorIndexOfRol)) {
          _tmpRol = null;
        } else {
          _tmpRol = _cursor.getString(_cursorIndexOfRol);
        }
        final boolean _tmpAprobado;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAprobado);
        _tmpAprobado = _tmp != 0;
        final String _tmpDireccionLocal;
        if (_cursor.isNull(_cursorIndexOfDireccionLocal)) {
          _tmpDireccionLocal = null;
        } else {
          _tmpDireccionLocal = _cursor.getString(_cursorIndexOfDireccionLocal);
        }
        _result = new UserEntity(_tmpNombre,_tmpCorreo,_tmpPassword,_tmpTelefono,_tmpPais,_tmpCiudad,_tmpRol,_tmpAprobado,_tmpDireccionLocal);
        _result.id = _cursor.getInt(_cursorIndexOfId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserEntity> obtenerVeterinariosPendientes() {
    final String _sql = "SELECT * FROM users WHERE rol = 'veterinario' AND aprobado = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
      final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfAprobado = CursorUtil.getColumnIndexOrThrow(_cursor, "aprobado");
      final int _cursorIndexOfDireccionLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "direccionLocal");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final UserEntity _item;
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpCorreo;
        if (_cursor.isNull(_cursorIndexOfCorreo)) {
          _tmpCorreo = null;
        } else {
          _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        final String _tmpPais;
        if (_cursor.isNull(_cursorIndexOfPais)) {
          _tmpPais = null;
        } else {
          _tmpPais = _cursor.getString(_cursorIndexOfPais);
        }
        final String _tmpCiudad;
        if (_cursor.isNull(_cursorIndexOfCiudad)) {
          _tmpCiudad = null;
        } else {
          _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
        }
        final String _tmpRol;
        if (_cursor.isNull(_cursorIndexOfRol)) {
          _tmpRol = null;
        } else {
          _tmpRol = _cursor.getString(_cursorIndexOfRol);
        }
        final boolean _tmpAprobado;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAprobado);
        _tmpAprobado = _tmp != 0;
        final String _tmpDireccionLocal;
        if (_cursor.isNull(_cursorIndexOfDireccionLocal)) {
          _tmpDireccionLocal = null;
        } else {
          _tmpDireccionLocal = _cursor.getString(_cursorIndexOfDireccionLocal);
        }
        _item = new UserEntity(_tmpNombre,_tmpCorreo,_tmpPassword,_tmpTelefono,_tmpPais,_tmpCiudad,_tmpRol,_tmpAprobado,_tmpDireccionLocal);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserEntity> obtenerVeterinariosAprobados() {
    final String _sql = "SELECT * FROM users WHERE rol = 'veterinario' AND aprobado = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
      final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfAprobado = CursorUtil.getColumnIndexOrThrow(_cursor, "aprobado");
      final int _cursorIndexOfDireccionLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "direccionLocal");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final UserEntity _item;
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpCorreo;
        if (_cursor.isNull(_cursorIndexOfCorreo)) {
          _tmpCorreo = null;
        } else {
          _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        final String _tmpPais;
        if (_cursor.isNull(_cursorIndexOfPais)) {
          _tmpPais = null;
        } else {
          _tmpPais = _cursor.getString(_cursorIndexOfPais);
        }
        final String _tmpCiudad;
        if (_cursor.isNull(_cursorIndexOfCiudad)) {
          _tmpCiudad = null;
        } else {
          _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
        }
        final String _tmpRol;
        if (_cursor.isNull(_cursorIndexOfRol)) {
          _tmpRol = null;
        } else {
          _tmpRol = _cursor.getString(_cursorIndexOfRol);
        }
        final boolean _tmpAprobado;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAprobado);
        _tmpAprobado = _tmp != 0;
        final String _tmpDireccionLocal;
        if (_cursor.isNull(_cursorIndexOfDireccionLocal)) {
          _tmpDireccionLocal = null;
        } else {
          _tmpDireccionLocal = _cursor.getString(_cursorIndexOfDireccionLocal);
        }
        _item = new UserEntity(_tmpNombre,_tmpCorreo,_tmpPassword,_tmpTelefono,_tmpPais,_tmpCiudad,_tmpRol,_tmpAprobado,_tmpDireccionLocal);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserEntity> obtenerVeterinarios() {
    final String _sql = "SELECT * FROM users WHERE rol = 'veterinario'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
      final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfAprobado = CursorUtil.getColumnIndexOrThrow(_cursor, "aprobado");
      final int _cursorIndexOfDireccionLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "direccionLocal");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final UserEntity _item;
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpCorreo;
        if (_cursor.isNull(_cursorIndexOfCorreo)) {
          _tmpCorreo = null;
        } else {
          _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        final String _tmpPais;
        if (_cursor.isNull(_cursorIndexOfPais)) {
          _tmpPais = null;
        } else {
          _tmpPais = _cursor.getString(_cursorIndexOfPais);
        }
        final String _tmpCiudad;
        if (_cursor.isNull(_cursorIndexOfCiudad)) {
          _tmpCiudad = null;
        } else {
          _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
        }
        final String _tmpRol;
        if (_cursor.isNull(_cursorIndexOfRol)) {
          _tmpRol = null;
        } else {
          _tmpRol = _cursor.getString(_cursorIndexOfRol);
        }
        final boolean _tmpAprobado;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAprobado);
        _tmpAprobado = _tmp != 0;
        final String _tmpDireccionLocal;
        if (_cursor.isNull(_cursorIndexOfDireccionLocal)) {
          _tmpDireccionLocal = null;
        } else {
          _tmpDireccionLocal = _cursor.getString(_cursorIndexOfDireccionLocal);
        }
        _item = new UserEntity(_tmpNombre,_tmpCorreo,_tmpPassword,_tmpTelefono,_tmpPais,_tmpCiudad,_tmpRol,_tmpAprobado,_tmpDireccionLocal);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UserEntity obtenerUsuarioPorId(final int id) {
    final String _sql = "SELECT * FROM users WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
      final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfAprobado = CursorUtil.getColumnIndexOrThrow(_cursor, "aprobado");
      final int _cursorIndexOfDireccionLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "direccionLocal");
      final UserEntity _result;
      if (_cursor.moveToFirst()) {
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpCorreo;
        if (_cursor.isNull(_cursorIndexOfCorreo)) {
          _tmpCorreo = null;
        } else {
          _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        final String _tmpPais;
        if (_cursor.isNull(_cursorIndexOfPais)) {
          _tmpPais = null;
        } else {
          _tmpPais = _cursor.getString(_cursorIndexOfPais);
        }
        final String _tmpCiudad;
        if (_cursor.isNull(_cursorIndexOfCiudad)) {
          _tmpCiudad = null;
        } else {
          _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
        }
        final String _tmpRol;
        if (_cursor.isNull(_cursorIndexOfRol)) {
          _tmpRol = null;
        } else {
          _tmpRol = _cursor.getString(_cursorIndexOfRol);
        }
        final boolean _tmpAprobado;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAprobado);
        _tmpAprobado = _tmp != 0;
        final String _tmpDireccionLocal;
        if (_cursor.isNull(_cursorIndexOfDireccionLocal)) {
          _tmpDireccionLocal = null;
        } else {
          _tmpDireccionLocal = _cursor.getString(_cursorIndexOfDireccionLocal);
        }
        _result = new UserEntity(_tmpNombre,_tmpCorreo,_tmpPassword,_tmpTelefono,_tmpPais,_tmpCiudad,_tmpRol,_tmpAprobado,_tmpDireccionLocal);
        _result.id = _cursor.getInt(_cursorIndexOfId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserEntity> obtenerTodosLosUsuarios() {
    final String _sql = "SELECT * FROM users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
      final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
      final int _cursorIndexOfCiudad = CursorUtil.getColumnIndexOrThrow(_cursor, "ciudad");
      final int _cursorIndexOfRol = CursorUtil.getColumnIndexOrThrow(_cursor, "rol");
      final int _cursorIndexOfAprobado = CursorUtil.getColumnIndexOrThrow(_cursor, "aprobado");
      final int _cursorIndexOfDireccionLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "direccionLocal");
      final List<UserEntity> _result = new ArrayList<UserEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final UserEntity _item;
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpCorreo;
        if (_cursor.isNull(_cursorIndexOfCorreo)) {
          _tmpCorreo = null;
        } else {
          _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final String _tmpTelefono;
        if (_cursor.isNull(_cursorIndexOfTelefono)) {
          _tmpTelefono = null;
        } else {
          _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
        }
        final String _tmpPais;
        if (_cursor.isNull(_cursorIndexOfPais)) {
          _tmpPais = null;
        } else {
          _tmpPais = _cursor.getString(_cursorIndexOfPais);
        }
        final String _tmpCiudad;
        if (_cursor.isNull(_cursorIndexOfCiudad)) {
          _tmpCiudad = null;
        } else {
          _tmpCiudad = _cursor.getString(_cursorIndexOfCiudad);
        }
        final String _tmpRol;
        if (_cursor.isNull(_cursorIndexOfRol)) {
          _tmpRol = null;
        } else {
          _tmpRol = _cursor.getString(_cursorIndexOfRol);
        }
        final boolean _tmpAprobado;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfAprobado);
        _tmpAprobado = _tmp != 0;
        final String _tmpDireccionLocal;
        if (_cursor.isNull(_cursorIndexOfDireccionLocal)) {
          _tmpDireccionLocal = null;
        } else {
          _tmpDireccionLocal = _cursor.getString(_cursorIndexOfDireccionLocal);
        }
        _item = new UserEntity(_tmpNombre,_tmpCorreo,_tmpPassword,_tmpTelefono,_tmpPais,_tmpCiudad,_tmpRol,_tmpAprobado,_tmpDireccionLocal);
        _item.id = _cursor.getInt(_cursorIndexOfId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
