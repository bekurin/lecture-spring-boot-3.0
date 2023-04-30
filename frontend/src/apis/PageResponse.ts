export type PageResponse<T> = {
    totalCount: number;
    currentPage: number;
    nextPage: number;
    hasNext: boolean;
    hasPrevious: boolean;
    contents: T[];
  };
  