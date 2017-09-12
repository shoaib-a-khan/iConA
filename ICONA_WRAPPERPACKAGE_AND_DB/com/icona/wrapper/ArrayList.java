package com.icona.wrapper;

//Mapping of NSMutableArray
public class ArrayList extends Array {

	java.util.ArrayList currentList;

	public static ArrayList alloc(){
		return new ArrayList();
	}
	
	public ArrayList(){
		
	}
	//+ (id)arrayWithCapacity:(NSUInteger)numItems
	public static ArrayList arrayWithCapacity(int numItems)// i believe this should be a constructor but since the next function does the same thing i will dicuss this later
	{
		return new ArrayList(numItems);
	}
	
	//- (id)initWithCapacity:(NSUInteger)numItems
	public ArrayList initWithCapacity(int numItems)
	{
		currentList = new java.util.ArrayList(numItems);
		return this;
	}
	
	public ArrayList(int numItems){
		currentList=new java.util.ArrayList(numItems);
	}
	
	//- (void)addObject:(id)anObject
	public void add(Object anObject)
	{
		currentList.add(anObject);
	}
	
	//- (void)addObjectsFromArray:(NSArray *)otherArray
	public void addObjectsFromArray(java.util.ArrayList otherArray)
	{
		currentList.addAll(otherArray);
	}
	
	//- (void)insertObject:(id)anObject atIndex:(NSUInteger)index
	public void insertObject_atIndex(Object anObject, int index)
	{
		currentList.add(index, anObject);
	}
	
	//- (void)insertObjects:(NSArray *)objects atIndexes:(NSIndexSet *)indexes
	public void insertObjects_atIndexes(java.util.ArrayList Objects, int[] indexes)
	{
		for(int i = 0; i < Objects.size(); ++i)
		{
			currentList.add(indexes[i], Objects.get(i));
		}
	}
	
	//- (void)removeAllObjects
	public void clear()
	{
		currentList.clear();
	}
	
	//- (void)removeLastObject
	public void removeLastObject()
	{
		currentList.remove((currentList.size()-1));
		currentList.trimToSize();
	}
	
	//- (void)removeObject:(id)anObject
	public void remove(Object anObject)
	{
		for(int i = 0; i < currentList.size(); ++i)
			if(currentList.get(i).equals(anObject))
				currentList.remove(anObject);
	}
	
	//- (void)removeObject:(id)anObject inRange:(NSRange)aRange
	public void removeObject_inRange(Object anObject, Range aRange)
	{
		for(int i = aRange.location; i < (i+aRange.length); ++i)
		{
			if(currentList.get(i).equals(anObject))
			{
				currentList.remove(i);
			}
		}
	}
	
	//- (void)removeObjectAtIndex:(NSUInteger)index
	public void remove(int index)
	{
		currentList.remove(index);
	}
	
	//- (void)removeObjects:(NSArray *)objects atIndexes:(NSIndexSet *)indexes
	public void removeObjects_atIndexes(int[] indexes)
	{
		for(int i = 0; i < indexes.length; ++i)
			currentList.remove(indexes[i]);
	}
	
	//- (void)removeObjectIdenticalTo:(id)anObject
	public void removeObjectIdenticalTo(Object anObject)
	{
		currentList.remove(anObject);
	}//TODO
	
	//- (void)removeObjectIdenticalTo:(id)anObject inRange:(NSRange)aRange
	public void removeObjectIdenticalTo_inRange(Object anObject, Range aRange)
	{
		this.removeObject_inRange(anObject, aRange);
	}//TODO
	
	//- (void)removeObjectsInArray:(NSArray *)otherArray
	public void removeObjectsInArray(java.util.ArrayList otherArray)
	{
		for(int i = 0; i < otherArray.size(); ++i)
		{
			this.remove(otherArray.get(i));
		}
	}
	
	//- (void)removeObjectsInRange:(NSRange)aRange
	public void removeObjectsInRange(Range aRange)
	{
		for(int i = aRange.location; i < aRange.length; ++i)
		{
			currentList.remove(i);
		}
		currentList.trimToSize();
	}
	
	//- (void)replaceObjectAtIndex:(NSUInteger)index withObject:(id)anObject
	public void set(int index, Object anObject)
	{
		currentList.set(index, anObject);
	}
	
	//- (void)replaceObjectsAtIndexes:(NSIndexSet *)indexes withObjects:(NSArray *)objects	
	public void replaceObjectsAtIndexes_withObjects(int[] indexes, java.util.ArrayList objects)
	{
		for(int i = 0; i < objects.size(); ++i)
		{
			currentList.set(indexes[i], objects.get(i));
		}
	}
	
	//- (void)replaceObjectsInRange:(NSRange)aRange withObjectsFromArray:(NSArray *)otherArray range:(NSRange)otherRange
	public void replaceObjectsInRange_ithObjectsFromArray_inRange(Range aRange, java.util.ArrayList otherArray, Range otherRange)
	{
		if(aRange.length == otherRange.length)
		{
			for(int i = aRange.location, j = otherRange.location; j < (otherRange.location + otherRange.length); ++i, ++j)
				currentList.set(i, otherArray.get(j));
		}
		else if(aRange.length > otherRange.length)
		{
			int t = aRange.location + aRange.length;
			int j = 0, i = 0;
			for(i = aRange.location, j = otherRange.location; j < (otherRange.location + otherRange.length); ++i, ++j)
				currentList.set(i, otherArray.get(j));
			Range range = new Range();
			range.location = j;
			range.length = t;
			this.removeObjectsInRange(range);
		}
		else
		{
			for(int i = aRange.location, j = otherRange.location; i < (aRange.location + aRange.length); ++i, ++j)
				currentList.set(i, otherArray.get(j));
			for(int j = otherRange.location; j < (otherRange.location + otherRange.length); ++j)
				currentList.add(otherArray.get(j));
		}
	}
	
	//- (void)replaceObjectsInRange:(NSRange)aRange withObjectsFromArray:(NSArray *)otherArray
	public void replaceObjectsInRange_withObjectsFromArray(Range aRange, java.util.ArrayList otherArray)
	{
		if(aRange.length == otherArray.size())
		{
			for(int i = aRange.location, j = 0; i < (aRange.location + aRange.length); ++i, ++j)
				currentList.set(i, otherArray.get(j));
		}
		else if(aRange.length > otherArray.size())
		{
			int t = aRange.location + aRange.length;
			int j = 0;
			for(int i = aRange.location; j < otherArray.size(); ++i, ++j)
				currentList.set(i, otherArray.get(j));
			Range range = new Range();
			range.location = j;
			range.length = t;
			this.removeObjectsInRange(range);
		}
		else
		{
			for(int i = aRange.location, j = 0; i < (aRange.location + aRange.length); ++i, ++j)
				currentList.set(i, otherArray.get(j));
			for(int j = 0; j < otherArray.size(); ++j)
				currentList.add(otherArray.get(j));
		}
	}
	
	//- (void)setArray:(NSArray *)otherArray
	public void setArray(java.util.ArrayList otherArray)
	{
		currentList = (java.util.ArrayList)otherArray.clone();
	}
	
	//- (void)exchangeObjectAtIndex:(NSUInteger)idx1 withObjectAtIndex:(NSUInteger)idx2
	public void exchangeObjectAtIndex_withObjectAtIndex(int idx1, int idx2)
	{
		Object temp = currentList.get(idx1);
		currentList.set(idx1, currentList.get(idx2));
		currentList.set(idx2, temp);
	}
	
	//objectArIndex:(NSUInteger) index
	public Object get(int index)
	{
		return currentList.get(index);
	}
	
	//NSUInteger count()
	public int size(){
		return currentList.size();
	}
}
