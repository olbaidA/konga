package it.konga.framework.datastruct;

import java.util.Iterator;

public class KListIterator<T> implements Iterator<T>
{

	protected KLinkedList<T>.ZListNode _pNode;
	protected KLinkedList<T> _pList;
	
	// *************************************************************************************************
	// 									costruttori
	// *************************************************************************************************
	public KListIterator(){
	}
	
	public KListIterator( KLinkedList<T> pList)
	{
		_pList = pList;
		_pNode = _pList._head;
	}
	
	public KListIterator( KListIterator<T> it)
	{
		_pList = it._pList; _pNode = it._pNode;
	}
	
	protected KListIterator(KLinkedList<T> zLinkedList, KLinkedList<T>.ZListNode node)
	{
		_pList = zLinkedList;
		_pNode = node;
	}
	
	// *************************************************************************************************
	// 									metodi publici
	// *************************************************************************************************
	

	@Override
	public int hashCode()
	{
		final int prime = 5;
		int result = prime + ((_pList == null) ? 0 : _pList.hashCode());
		result = prime * result + ((_pNode == null) ? 0 : _pNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof KListIterator))
			return false;
		@SuppressWarnings("rawtypes")
		KListIterator other = (KListIterator) obj;
		if (_pList == null)
		{
			if (other._pList != null)
				return false;
		} else if (!_pList.equals(other._pList))
			return false;
		if (_pNode == null)
		{
			if (other._pNode != null)
				return false;
		} else if (!_pNode.equals(other._pNode))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "ZListIterator on List with code " + _pList.hashCode();
	}

	/**
	 * valore del nodo puntato
	 */
	public T getData()					{if(_pNode== null) return null; return _pNode.getData();}
	public boolean isValid()			{return _pNode != null;}
	public void gotoBegin()				{if(_pList != null) _pNode= _pList._head;}
	public void gotoEnd()				{if(_pList != null) _pNode = _pList._tail;}
	public void clear()					{_pList = null; _pNode = null;}

	// *************************************************************************************************
	// 									implements iterator
	// *************************************************************************************************
	
	@Override
	public boolean hasNext()
	{
		if(_pNode == null)
			return false;
		return true;
	}

	/**
	 * return current data and move to next
	 */
	@Override
	public T next()
	{
		if( !hasNext() )
		{
			return null;
		}
		KLinkedList<T>.ZListNode previous = _pNode;
		_pNode = _pNode.next();
		return previous.getData();
	}
	
	@Override
	public void remove()
	{
		if( _pList== null || _pNode == null)
			return;
		_pList.remove(this);
	}
}